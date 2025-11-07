<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
</head>
<body>

  <h1>🏨 Hotel Management System</h1>

  <div class="section">
    <h2>📖 Overview</h2>
    <p>
      The <strong>Hotel Management System</strong> is a full-stack web application built using 
      <strong>Angular</strong> for the frontend and <strong>Spring Boot</strong> for the backend. 
      It provides hotel administrators and staff with an efficient platform to manage 
      bookings, customers, payments, and room availability.
    </p>
    <p>
      This system reduces manual operations, streamlines communication between departments, 
      and provides a seamless user experience with a responsive and modern interface. 
      <strong>Postman</strong> is used for API testing, and the project is developed in 
      <strong>IntelliJ IDEA</strong>.
    </p>
  </div>

  <div class="section">
    <h2>🧰 Tech Stack</h2>
    <ul>
      <li><strong>Frontend:</strong> Angular 19.1.4 (HTML, CSS, TypeScript)</li>
      <li><strong>Backend:</strong> Java Spring Boot</li>
      <li><strong>Database:</strong> MySQL / H2 Database (configurable)</li>
      <li><strong>API Testing:</strong> Postman in IntelliJ IDEA</li>
      <li><strong>Version Control:</strong> Git & GitHub</li>
    </ul>
  </div>

  <div class="section">
    <h2>🚀 Getting Started</h2>
    <h3>1️⃣ Frontend Setup (Angular)</h3>
    <pre>
# Navigate to Angular frontend
cd angular-frontend

# Install dependencies
npm install

# Start development server
ng serve
    </pre>
    <p>
      Once the server is running, open your browser and visit:
      <code>http://localhost:4200/</code>
    </p>

    <h3>2️⃣ Backend Setup (Spring Boot)</h3>
    <pre>
# Run the Spring Boot Application
mvn spring-boot:run
    </pre>
    <p>
      The backend API will be available at:
      <code>http://localhost:8080/</code>
    </p>
  </div>

  <div class="section">
    <h2>🧩 Project Structure</h2>
    <ul>
      <li><strong>AuthController.java</strong> – Handles authentication & login.</li>
      <li><strong>BookingController.java</strong> – Manages booking operations.</li>
      <li><strong>RoomController.java</strong> – Handles room data and availability.</li>
      <li><strong>UserController.java</strong> – User and staff management.</li>
      <li><strong>Service & Impl Classes</strong> – Business logic implementation.</li>
      <li><strong>Angular Frontend</strong> – User interface for hotel operations.</li>
      <li><strong>SRS.docx</strong> – Software Requirement Specification document.</li>
    </ul>
  </div>

  <div class="section">
    <h2>⚙️ Features</h2>
    <ul>
      <li>User authentication (Admin, Staff, Customer roles)</li>
      <li>Room booking and cancellation</li>
      <li>Payment processing & status tracking</li>
      <li>Notifications for users and admin</li>
      <li>Centralized customer management</li>
      <li>Real-time booking status updates</li>
      <li>Responsive web design for desktop and mobile</li>
    </ul>
  </div>

  <div class="section">
    <h2>🧪 Testing</h2>
    <p>Use <strong>Postman</strong> to test all REST APIs. Endpoints include:</p>
    <ul>
      <li><code>/api/auth/login</code></li>
      <li><code>/api/booking/create</code></li>
      <li><code>/api/room/all</code></li>
      <li><code>/api/payment/status</code></li>
    </ul>
  </div>

  <div class="section">
    <h2>👥 Contributors</h2>
    <ul>
      <li><strong>Vikas Das</strong> – Project Lead & Developer</li>
      <li><strong>Shrabanee04</strong> – Frontend Development</li>
      <li><strong>Dixita-05</strong> – Backend & API Integration</li>
    </ul>
  </div>

  <div class="section">
    <h2>📚 License & Resources</h2>
    <p>
      This project is open-source and available under the <strong>MIT License</strong>.
    </p>
    <p>Additional resources:</p>
    <ul>
      <li><a href="https://angular.io/cli" target="_blank">Angular CLI Documentation</a></li>
      <li><a href="https://spring.io/projects/spring-boot" target="_blank">Spring Boot Docs</a></li>
      <li><a href="https://www.postman.com/" target="_blank">Postman API Testing</a></li>
    </ul>
  </div>

  <div class="footer">
    <p>© 2025 <strong>Hotel Management System</strong> | Developed by Team HMS 💻</p>
  </div>

</body>
</html>
