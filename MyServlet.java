package com.example;

/*package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:sqlserver://magesh\\SQLEXPRESS;databaseName=lalithadb";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "@kavi";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Establish database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL statement for read
            String readSql = "SELECT * FROM DATA";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(readSql);

            out.println("<html><head><title>Data Management</title></head><body>");
            out.println("<h1>Data Management System</h1>");

            // Display data from database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dbName = resultSet.getString("name");
                String dbAge = resultSet.getString("age");

                out.println("<p>ID: " + id + "</p>");
                out.println("<p>Name: " + dbName + "</p>");
                out.println("<p>Age: " + dbAge + "</p>");
                out.println("<hr>");
            }

            out.println("</body></html>");

            // Clean up resources
            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve input data from the HTML form
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        try {
            // Establish database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL statement for insert
            String insertSql = "INSERT INTO DATA (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertSql);
            insertStatement.setString(1, id);
            insertStatement.setString(2, name);
            insertStatement.setString(3, age);

            // Execute insert SQL statement
            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<html><head><title>Servlet Example</title></head><body>");
                out.println("<h1>Data inserted successfully into the database.</h1>");
                out.println("</body></html>");
            }

            // Clean up resources
            insertStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve input data from the HTML form
        int id = Integer.parseInt(request.getParameter("id"));
        String newName = request.getParameter("newName");
        String newAge = request.getParameter("newAge");

        try {
            // Establish database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL statement for update
            String updateSql = "UPDATE DATA SET name = ?, age = ? WHERE id = ?";
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);

            updateStatement.setString(1, newName);
            updateStatement.setString(2, newAge);
            updateStatement.setInt(3, id);

            // Execute update SQL statement
            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                out.println("<html><head><title>Servlet Example</title></head><body>");
                out.println("<h1>Data updated successfully.</h1>");
                out.println("</body></html>");
            } else {
                out.println("<html><head><title>Servlet Example</title></head><body>");
                out.println("<h1>No data updated.</h1>");
                out.println("</body></html>");
            }

            // Clean up resources
            updateStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve input data from the HTML form
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            // Establish database connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL statement for delete
            String deleteSql = "DELETE FROM DATA WHERE id = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
            deleteStatement.setInt(1, id);

            // Execute delete SQL statement
            int rowsDeleted = deleteStatement.executeUpdate();
            if (rowsDeleted > 0) {
                out.println("<html><head><title>Servlet Example</title></head><body>");
                out.println("<h1>Data deleted successfully.</h1>");
                out.println("</body></html>");
            } else {
                out.println("<html><head><title>Servlet Example</title></head><body>");
                out.println("<h1>No data deleted.</h1>");
                out.println("</body></html>");
            }

            // Clean up resources
            deleteStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
*/

/*import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/crud")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:sqlserver://magesh\\SQLEXPRESS;databaseName=lalithadb";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "@kavi";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String readSql = "SELECT * FROM DATA";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(readSql);

            out.println("<html><head><title>Data Management System</title>");
            out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
            out.println("</head><body>");
            out.println("<h1>Data Management System</h1>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dbName = resultSet.getString("name");
                int dbAge = resultSet.getInt("age");

                out.println("<div class='data-item'>");
                out.println("<p>ID: " + id + "</p>");
                out.println("<p>Name: " + dbName + "</p>");
                out.println("<p>Age: " + dbAge + "</p>");
                out.println("</div>");
            }

            out.println("<a href='NewFile.html'>Back to Main Page</a>");

            out.println("</body></html>");

            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String insertSql = "INSERT INTO DATA (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertSql);
            insertStatement.setString(1, id);
            insertStatement.setString(2, name);
            insertStatement.setString(3, age);

            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<html><head><title>Servlet Example</title>");
                out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                out.println("</head><body>");
                out.println("<h1>Data inserted successfully into the database.</h1>");
                out.println("<a href='NewFile.html'>Back to Main Page</a>");
                out.println("</body></html>");
            }

            insertStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String newName = request.getParameter("newName");
        String newAge = request.getParameter("newAge");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String updateSql = "UPDATE DATA SET id = ?, newName = ? WHERE newAge = ?";
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            
            updateStatement.setInt(1, id);
            updateStatement.setString(2, newName);
            updateStatement.setString(3, newAge);
          //  updateStatement.setInt(3, id);

            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                out.println("<html><head><title>Servlet Example</title>");
                out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                out.println("</head><body>");
                out.println("<h1>Data updated successfully.</h1>");
                out.println("<a href='NewFile.html'>Back to Main Page</a>");
                out.println("</body></html>");
            } else {
                out.println("<html><head><title>Servlet Example</title>");
                out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                out.println("</head><body>");
                out.println("<h1>No data updated.</h1>");
                out.println("<a href='NewFile.html'>Back to Main Page</a>");
                out.println("</body></html>");
            }

            updateStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String deleteSql = "DELETE FROM DATA WHERE id = ?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
            deleteStatement.setInt(1, id);

            int rowsDeleted = deleteStatement.executeUpdate();
            if (rowsDeleted > 0) {
                out.println("<html><head><title>Servlet Example</title>");
                out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                out.println("</head><body>");
                out.println("<h1>Data deleted successfully.</h1>");
                out.println("<a href='NewFile.html'>Back to Main Page</a>");
                out.println("</body></html>");
            } else {
                out.println("<html><head><title>Servlet Example</title>");
                out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                out.println("</head><body>");
                out.println("<h1>No data deleted.</h1>");
                out.println("<a href='NewFile.html'>Back to Main Page</a>");
                out.println("</body></html>");
            }

            deleteStatement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
*/


/*import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/crud")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:sqlserver://magesh\\SQLEXPRESS;databaseName=lalithadb";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "@kavi";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String readSql = "SELECT * FROM DATA";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(readSql);

            out.println("<html><head><title>Data Management System</title>");
            out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
            out.println("</head><body>");
            out.println("<h1>Data Management System</h1>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dbName = resultSet.getString("name");
                int dbAge = resultSet.getInt("age");

                out.println("<div class='data-item'>");
                out.println("<p>ID: " + id + "</p>");
                out.println("<p>Name: " + dbName + "</p>");
                out.println("<p>Age: " + dbAge + "</p>");
                out.println("</div>");
            }

            out.println("<a href='crud'>Back to Main Page</a>");

            out.println("</body></html>");

            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            // Handle Insert operation here
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String age = request.getParameter("age");

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                String insertSql = "INSERT INTO DATA (id, name, age) VALUES (?, ?, ?)";
                PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                insertStatement.setString(1, id);
                insertStatement.setString(2, name);
                insertStatement.setString(3, age);

                int rowsInserted = insertStatement.executeUpdate();
                if (rowsInserted > 0) {
                    out.println("<html><head><title>Servlet Example</title>");
                    out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                    out.println("</head><body>");
                    out.println("<h1>Data inserted successfully into the database.</h1>");
                    out.println("<a href='crud'>Back to Main Page</a>");
                    out.println("</body></html>");
                }

                insertStatement.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                out.println("Error: " + e.getMessage());
            }
        } else if ("update".equals(action)) {
        	
        	 int id = Integer.parseInt(request.getParameter("id"));
             String newName = request.getParameter("newName");
             String newAge = request.getParameter("newAge");

             try {
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                 Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                 String updateSql = "UPDATE DATA SET name = ?, age = ? WHERE id = ?";
                 PreparedStatement updateStatement = conn.prepareStatement(updateSql);

                 updateStatement.setString(1, newName);
                 updateStatement.setString(2, newAge);
                 updateStatement.setInt(3, id);

                 int rowsUpdated = updateStatement.executeUpdate();
                 if (rowsUpdated > 0) {
                     out.println("<html><head><title>Servlet Example</title>");
                     out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                     out.println("</head><body>");
                     out.println("<h1>Data updated successfully.</h1>");
                     out.println("<a href='crud'>Back to Main Page</a>");
                     out.println("</body></html>");
                 } else {
                     out.println("<html><head><title>Servlet Example</title>");
                     out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                     out.println("</head><body>");
                     out.println("<h1>No data updated.</h1>");
                     out.println("<a href='crud'>Back to Main Page</a>");
                     out.println("</body></html>");
                 }

                 updateStatement.close();
                 conn.close();
             } catch (ClassNotFoundException | SQLException e) {
                 out.println("Error: " + e.getMessage());
             }
            
            // ... (Update operation code, as shown in previous responses)
        } else if ("delete".equals(action)) {
        	
        	 int id = Integer.parseInt(request.getParameter("id"));

             try {
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                 Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                 String deleteSql = "DELETE FROM DATA WHERE id = ?";
                 PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                 deleteStatement.setInt(1, id);

                 int rowsDeleted = deleteStatement.executeUpdate();
                 if (rowsDeleted > 0) {
                     out.println("<html><head><title>Servlet Example</title>");
                     out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                     out.println("</head><body>");
                     out.println("<h1>Data deleted successfully.</h1>");
                     out.println("<a href='crud'>Back to Main Page</a>");
                     out.println("</body></html>");
                 } else {
                     out.println("<html><head><title>Servlet Example</title>");
                     out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                     out.println("</head><body>");
                     out.println("<h1>No data deleted.</h1>");
                     out.println("<a href='crud'>Back to Main Page</a>");
                     out.println("</body></html>");
                 }

                 deleteStatement.close();
                 conn.close();
             } catch (ClassNotFoundException | SQLException e) {
                 out.println("Error: " + e.getMessage());
             }
        	
        	
        	
        	
        	
        	
            // ... (Delete operation code, as shown in previous responses)
        }
    }
}*/
																					

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/crud")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:sqlserver://magesh\\SQLEXPRESS;databaseName=lalithadb";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "@kavi";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String readSql = "SELECT * FROM DATA";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(readSql);

            out.println("<html><head><title>Data Management System</title>");
            out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
            out.println("</head><body>");
            out.println("<h1>Data Management System</h1>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String dbName = resultSet.getString("name");
                int dbAge = resultSet.getInt("age");

                out.println("<div class='data-item'>");
                out.println("<p>ID: " + id + "</p>");
                out.println("<p>Name: " + dbName + "</p>");
                out.println("<p>Age: " + dbAge + "</p>");
                out.println("</div>");
            }

            out.println("<a href='crud'>Back to Main Page</a>");

            out.println("</body></html>");

            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            // Handle Insert operation here
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String age = request.getParameter("age");

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                String insertSql = "INSERT INTO DATA (id, name, age) VALUES (?, ?, ?)";
                PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                insertStatement.setString(1, id);
                insertStatement.setString(2, name);
                insertStatement.setString(3, age);

                int rowsInserted = insertStatement.executeUpdate();
                if (rowsInserted > 0) {
                    out.println("<html><head><title>Servlet Example</title>");
                    out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                    out.println("</head><body>");
                    out.println("<h1>Data inserted successfully into the database.</h1>");
                    out.println("<a href='crud'>Back to Main Page</a>");
                    out.println("</body></html>");
                }

                insertStatement.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                out.println("Error: " + e.getMessage());
            }
        } else if ("update".equals(action)){
            // Handle Update operation here
            int id = Integer.parseInt(request.getParameter("id"));
            String newName = request.getParameter("newName");
            int newAge = Integer.parseInt(request.getParameter("newAge"));

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                String updateSql = "UPDATE DATA SET name = ?, age = ? WHERE id = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateSql);

                updateStatement.setString(1, newName);
                updateStatement.setInt(2, newAge);
                updateStatement.setInt(3, id);

                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    out.println("<html><head><title>Servlet Example</title>");
                    out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                    out.println("</head><body>");
                    out.println("<h1>Data updated successfully.</h1>");
                    out.println("<a href='crud'>Back to Main Page</a>");
                    out.println("</body></html>");
                } else {
                    out.println("<html><head><title>Servlet Example</title>");
                    out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                    out.println("</head><body>");
                    out.println("<h1>No data updated.</h1>");
                    out.println("<a href='crud'>Back to Main Page</a>");
                    out.println("</body></html>");
                }

                updateStatement.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                out.println("Error: " + e.getMessage());
            }
        } else if ("delete".equals(action)) {
            // Handle Delete operation here
            int id = Integer.parseInt(request.getParameter("id"));

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                String deleteSql = "DELETE FROM DATA WHERE id = ?";
                PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
                deleteStatement.setInt(1, id);

                int rowsDeleted = deleteStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    out.println("<html><head><title>Servlet Example</title>");
                    out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                    out.println("</head><body>");
                    out.println("<h1>Data deleted successfully.</h1>");
                    out.println("<a href='crud'>Back to Main Page</a>");
                    out.println("</body></html>");
                } else {
                    out.println("<html><head><title>Servlet Example</title>");
                    out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
                    out.println("</head><body>");
                    out.println("<h1>No data deleted.</h1>");
                    out.println("<a href='crud'>Back to Main Page</a>");
                    out.println("</body></html>");
                }

                deleteStatement.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                out.println("Error: " + e.getMessage());
            }
        }
    }
}









