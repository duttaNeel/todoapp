# 📝 Spring Boot To-Do App with PostgreSQL & Frontend

This is a full-stack To-Do List web application built using **Spring Boot**, **PostgreSQL**, and a simple **HTML/CSS/JS frontend**. It features task creation, deletion, completion toggle, category tags, due dates, priority levels, theme toggle, inline editing, and user login (basic).

---

## 🚀 Features

- ✅ Add, Edit, Delete tasks
- 🕒 Task due date selector
- ⭐ Task priority (Low/Medium/High)
- 🏷️ Task categories with color tags
- 🎨 Light/Dark theme toggle
- ✏️ Inline task editing
- 🔢 Live task counter
- 🔐 Basic Login/Register UI (dummy for now)
- 🎨 Beautiful UI with animations
- 📦 PostgreSQL database backend

---

## 🛠️ Tech Stack

| Layer        | Tech Used            |
|--------------|----------------------|
| Frontend     | HTML, CSS, JavaScript |
| Backend      | Spring Boot (Java 17) |
| Database     | PostgreSQL            |
| ORM          | Spring Data JPA       |
| Security     | Spring Security (Basic) |
| Build Tool   | Maven                 |

---

## 📁 Project Structure

todo-app/
├── src/
│ ├── main/
│ │ ├── java/com/example/todoapp/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ └── TodoAppApplication.java
│ │ └── resources/
│ │ ├── application.properties
│ └── ...
├── frontend/
│ └── index.html
├── pom.xml 

---

## ⚙️ Setup Instructions

### 📦 Requirements
- Java 17+
- Maven
- PostgreSQL installed and running

### 🧪 Configure PostgreSQL

Update your `application.properties` like this:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todoapp
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.h2.console.enabled=false
🚀 Run the Backend
bash
mvn clean install
mvn spring-boot:run
🌐 Run the Frontend
bash
cd frontend
python -m http.server 5500
Open: http://localhost:5500

🛡️ Security
Currently uses a dummy login/register page. You can upgrade this by adding JWT Authentication or Spring Security with a real database.

📌 Future Improvements
🔐 Secure JWT-based login

🧠 AI-based task suggestions

☁️ Cloud deployment (Render/Heroku)

📱 Responsive design for mobile

🤝 Contributing
Feel free to fork, improve, and submit pull requests. Let’s build together!

📸 Screenshots
Add screenshots here if you’d like

📄 License
This project is open-source under the MIT License.

---

### ✅ To Use:
1. Save it as `README.md` in your project root.
2. Run:

```bash
git add README.md
git commit -m "Add custom project README"
git push
