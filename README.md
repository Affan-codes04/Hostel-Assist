# 🏨 Hostel Assist App

Welcome to **Hostel Assist**, a smart and efficient mobile app designed to simplify hostel-related operations and communication.  
Built using **Android + Firebase**, this app supports real-time complaint handling, user authentication, and push notifications.

---

## 📌 Description

This app was created to streamline the communication between **students** and **wardens** in a college hostel environment.  
It enables students to log complaints/issues and receive updates in real-time, while wardens can manage and track issues efficiently.

---

## 🛠️ Features

- 🔐 **Firebase Authentication**
  - Email & Password-based registration/login
  - Secure user sessions for students and wardens

- 💬 **Realtime Database**
  - Students can file complaints (room issues, water, electricity, etc.)
  - Wardens can view, manage, and resolve complaints in real-time

- 🔔 **Push Notifications**
  - Get notified when complaint status is updated
  - Real-time updates keep users in the loop

- 📋 **User Role System**
  - Separate dashboards for students and wardens
  - Clean UI for viewing complaint status, submitting new issues, etc.

---

## 📱 Tech Stack

| Tech                 | Purpose                             |
|----------------------|-------------------------------------|
| Android (Java/Kotlin)| Core app development                |
| Firebase Auth        | User login and authentication       |
| Firebase Realtime DB | Live complaint data management      |
| Firebase Cloud Messaging (FCM) | Sending real-time notifications |

---

## 🚀 How to Run This Project

1. Clone the repository:

   ```bash
   git clone https://github.com/Affan-codes04/Hostel-Assist-App.git
   
2. Open the project in **Android Studio**

3. Connect your Firebase project:
   - Add `google-services.json` to your `app/` folder
   - Enable **Authentication**, **Realtime Database**, and **Cloud Messaging** in Firebase Console

4. Sync Gradle and run the app on an emulator or physical device

---

## 📃 Notes

- Uses **role-based login** to separate student & warden functionality  
- **Firebase security rules** are set to control data access  
- **Modular and scalable** codebase for future enhancements  
- Supports **real-time complaint tracking** with live status updates  
- Friendly UI for non-technical users (yep, even the grumpy warden 😅)

---

## 🧑‍💻 Author

**Affan Rahmathullah**  
GitHub: [Affan-codes04](https://github.com/Affan-codes04)
