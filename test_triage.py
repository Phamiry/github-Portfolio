import unittest
from triage import assess_email

class TestEmailTriage(unittest.TestCase):
    def test_safe_short_message(self):
        result = assess_email('Hi, thanks for your help. See you tomorrow.')
        self.assertEqual(result['level'], 'low')
        self.assertEqual(result['score'], 0)

    def test_phishing_signals(self):
        result = assess_email('URGENT: verify your account immediately! Click here: http://192.168.1.1/login')
        self.assertEqual(result['level'], 'high')
        self.assertTrue(any('raw IPv4' in x['signal'] for x in result['findings']))

    def test_empty_input(self):
        with self.assertRaises(ValueError):
            assess_email('   ')

    def test_capped_score(self):
        result = assess_email('Urgent verify your account. Gift card prize. Click here http://1.2.3.4/')
        self.assertLessEqual(result['score'], 100)

if __name__ == '__main__':
    unittest.main()
