# Email Threat Triage Assistant

An educational, defensive email-triage command-line application built in Python with AI-assisted development. Its **baseline** mode is an explainable heuristic scanner; its **optional local AI mode** asks an Ollama language model for a second opinion.

## Getting started (Python 3.9+)

From the `projects/email-threat-triage` folder:

```bash
python triage.py --file example_email.txt
python -m unittest discover -v
```

For a local language-model response (optional):

1. Install Ollama from https://ollama.com and start it.
2. Download a supported model: `ollama pull llama3.2`.
3. Run: `python triage.py --file example_email.txt --ollama`.

**Privacy:** The optional mode sends text to a local Ollama HTTP server at `127.0.0.1`, not to a hosted cloud model. Avoid processing real confidential messages unless you understand and approve your environment's handling of them.

## Features

- Scans text for urgency, credentials requests, financial requests, links, and IPv4-hosted URLs.
- Produces a 0–100 heuristic score, detected indicators, and a safe action recommendation.
- Supports optional local AI commentary while keeping deterministic scoring independent.
- Includes four automated tests, a sample message, and documented limitations.


## Limitations and responsible use

Rules yield false positives and false negatives; attackers can evade them. Links are not fetched or opened. The program does not inspect attachments, parse sender authenticity, run SPF/DKIM/DMARC, or do live threat-intelligence checks. A low score does **not** indicate an email is safe. LLM answers can hallucinate. Never treat this tool as a definitive verdict or automatically delete messages based on it.

## Screenshots

The following screenshots show the program running and the results of its four automated tests.


- [Email Threat Triage Results](../../screenshots/email-threat-triage.png)
- [Automated Test Results](../../screenshots/email-threat-triage-tests.png)
  
