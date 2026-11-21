# Project Overview

Project for Fall 2024 Artificial Intelligence (CPSC-4370-48F) course creating an AI Text Reader.

# Setup Instructions

## Prerequisites
- Python installed

- Check if Python is already installed on MacOS:
   ```bash
   python3 --version
   ```
- Check if Python is already installed on Windows
    ```cmd
    python --version
    ```

---

## Setup python environment
- Install FFmpeg on macOS:

   ```bash
   brew install ffmpeg
   ```

- Install FFmpeg on Windows:
https://www.wikihow.com/Install-FFmpeg-on-Windows


- Set up a virtual environment on macOS:

   ```bash
   python3 -m venv .venv
   source .venv/bin/activate
   ```

- Set up a virtual environment on Windows:

   ```cmd
   python -m venv .venv
   .venv\Scripts\activate
   ```

- Install dependencies:
  
   
   ```bash
   pip install -r requirements.txt
   ```

---
  

## ElevenLabs API Key

1. Create an account at [ElevenLabs](https://elevenlabs.io/).
2. Generate an API key from your account settings.
3. Keep your API key private. Never upload it to GitHub.
4. The Python application must be configured to read the API key securely before running.
  

# Run program


- Run the program on macOS:

   ```bash
   python3 app.py
   ```

- Run the program on Windows:

   ```cmd
   python app.py
   ```
  

- Input selection for entering text or file to generate speech


# Features

- Accepts text entered directly into the console.
- Reads text from a local text file.
- Generates speech using the ElevenLabs API.
- Uses the ElevenLabs multilingual speech model.
- Plays generated audio.
- Saves generated speech as an MP3 file.
  

