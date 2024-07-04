# A01-G01-IntelliCards

## Startup Guide for Iteration 2

| :memo:        | Please use portrait mode for the tablet to ensure proper user experience.       |
|---------------|:------------------------|

### Changing Data Sources

Graders can change between data sources by changing the variable "datasource" in "app/src/main/java/comp3350/intellicards/Application/Configuration.java"
The following variable values are recognized:
- "hsqldb"
- "testHsqldb"
- "stub"

If an unrecognized variable value is declared, the app will default to the HSQLDB

### Login Page

Graders can login with the following pre-inserted usernames and passwords unless they are using the Test HSQLDB. They contain fake data.

| Username | Password |
|----------|----------|
| user1    | pass1    |
| user2    | pass2    |
| user3    | pass3    |

- You can sign up with a new username and password. Once it is successful you will be able to login with it.

- You can also login as a guest user but will be limited by the features they can use.

## IntelliCards Vision Statement

IntelliCards will be a user-friendly flashcard application that allows users to create, edit, and organize flashcards to facilitate personalized and effective learning. The goal of the application is to make study materials more accessible and to give users a variety of ways to test their knowledge. Users will be able to track their progress, save their flashcards, and access various features designed to enhance their study experience. It also offers the flexibility of being able to customize their own flashcards and sets. Furthermore, it is envisioned to be used to motivate students to actively test themselves to effectively digest the contents that they are learning, rather than simply reading the notes over and over to just memorize them.

This mobile application is designed for students of all ages. The target users are those looking for help with testing and reviewing materials for their school, work, or personal education purposes, regardless of age. IntelliCards strives to bring enjoyment and interaction to studying. New users can register with a nickname and password. However, the app also caters to guest users. Registered users benefit from saved progress, badges, and notifications. Guests, on the other hand, can explore the app’s features and get a feel for its functionality before committing to registering. Each registered user will have a personalized profile page where they can view their study metrics. It will display the number of flashcards they have studied, the number of folders they have for studying, and their accuracy metrics for each set of flashcards.

As for the main creation of the flashcards, users will be able to create folders and sets of flashcards to keep study sessions organized. The app will allow users to upload images to flashcards adding more variety to their studying content. Users will also be able to edit existing flashcards and change priorities to keep everything up-to-date and relevant. Additionally, users can delete old flashcards they no longer need, but will able to recover them if needed.

The project is valuable because as AI systems consistently develop, people tend to stop studying or solving problems on their own, and simply ask AI to do the tasks for them. For everyone’s sake of actually understanding the concepts, introducing enjoyable studying methods that people can easily access anytime, anywhere, is crucial for success. The goal is to motivate people to learn information on their own. It also adds significant value by employing scientifically backed methods like space repetition through notifications to improve knowledge retention. 

This project's success will be measured by user engagement through notifications, retention, and improved user performance. Some key performance indicators include achieving over 500 user registrations within the first three months and a 20% increase in the number of correct answers on flashcards after one month of use for 80% of the user base. Additionally, the goal is for at least 70% of users to log in for study sessions at least three times per week. The ultimate goal is for users to feel that the app significantly enhances their learning experience and also contributes to their academic growth.