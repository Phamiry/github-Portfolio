# AI Prompt Log and Development Process

**Course:** COSC 4272 Senior Seminar  
**Project:** Email Threat Triage Assistant and GitHub Portfolio  
**AI tool:** ChatGPT (OpenAI)  
**Development and verification:** November 20–21, 2026

> The entries below summarize the requests and work completed. They are **paraphrases**, not verbatim transcripts. Review and edit them to match your own account of the development process.

| Step | Prompt or request summary | AI assistance or output | My review and verification |
| --- | --- | --- | --- |
| 1 | Help create a GitHub Pages portfolio for a Lamar University cybersecurity student, following the COSC 4272 requirements. | Drafted a website structure, HTML/CSS, and descriptions of education, skills, and projects. | Reviewed content, edited project titles, and organized project files in the GitHub repository. |
| 2 | Help create a cybersecurity-related Python project for the portfolio. | Produced the Email Threat Triage Assistant: a command-line program using explainable rules to flag suspicious email content, with an optional local Ollama analysis feature. | Ran the program against a sample email and inspected the risk score, warning signals, and recommended action. |
| 3 | Help organize AI Text Reader, Farkle, and Email Threat Triage into separate project folders. | Suggested repository folder structure and updated source-file paths for the website links. | Moved files in GitHub and checked that the three project folders were present under `projects/`. |
| 4 | Help fix the Email Threat Triage automated test file and explain how to run tests in VS Code. | Supplied four Python `unittest` cases: safe message, urgent message, phishing message, and empty input. | Replaced `test_triage.py` and ran `python -m unittest discover -s projects/email-threat-triage -p test_triage.py -v` from the repository folder. **All 4 tests passed** on November 21, 2026. |
| 5 | Help diagnose a Python testing error caused by running the test command from the wrong folder. | Explained how to use `dir` and change into the nested `github-Portfolio-main` directory. | Reran the command from the correct folder and captured a screenshot of the passing test results at `screenshots/email-threat-triage-tests.png`. |

## What I learned

ChatGPT helped me draft code and documentation, but I still needed to organize the repository, run the program, troubleshoot the working directory, and verify test results. Passing unit tests provide evidence for the four cases tested; they do not prove that the program will correctly identify every phishing email.

## Limitations and responsible use

- The core email scanner uses **rule-based checks**, not a trained phishing-detection model.
- The Ollama language-model feature is **optional** and has **not been verified** in the recorded testing.
- The tool is educational and should not replace human judgment or professional security tools.
- The AI Text Reader is a collaborative academic project; its contributor credit should remain accurate.

## Evidence

- Source: [`projects/email-threat-triage/triage.py`](../projects/email-threat-triage/triage.py)
- Tests: [`projects/email-threat-triage/test_triage.py`](../projects/email-threat-triage/test_triage.py)
- Sample message: [`projects/email-threat-triage/example_email.txt`](../projects/email-threat-triage/example_email.txt)
- Test screenshot: [`screenshots/email-threat-triage-tests.png`](../screenshots/email-threat-triage-tests.png)
- Program screenshot: [`screenshots/email-threat-triage.png`](../screenshots/email-threat-triage.png)
