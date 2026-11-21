import unittest
from triage import assess_email


class TestEmailThreatTriage(unittest.TestCase):

    def test_safe_email(self):
        result = assess_email(
            "Hello, our meeting is scheduled for tomorrow."
        )
        self.assertEqual(result["score"], 0)
        self.assertEqual(result["level"], "low")

    def test_urgent_email(self):
        result = assess_email(
            "URGENT! You must act now."
        )
        self.assertEqual(result["score"], 20)
        self.assertEqual(result["level"], "medium")

    def test_phishing_email(self):
        result = assess_email(
            "Urgent! Verify your account. "
            "Click here: http://192.168.1.10/login"
        )
        self.assertEqual(result["score"], 85)
        self.assertEqual(result["level"], "high")

    def test_empty_email(self):
        with self.assertRaises(ValueError):
            assess_email("")


if __name__ == "__main__":
    unittest.main()

