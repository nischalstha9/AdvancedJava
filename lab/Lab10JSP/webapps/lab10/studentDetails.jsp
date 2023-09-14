<!-- import example -->
<!-- example declaration -->
<%! String getLowerCase(String text){ return text.toLowerCase(); } %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
        import="lab.Lab10JSP.webapps.lab10.*" %>
        <!DOCTYPE html>
        <html>

            <head>
                <title>Student Details</title>
            </head>

            <body>
                <h1>Student Details</h1>
                <hr>

                <h5>Example Expression</h5>
                <p>
                    The time is <%= new java.util.Date() %>
                </p>
                <hr>

                <h5>Example loop as Scriptlet</h5>

                <% for( int i=0; i<5; i++) { String s="<p>Hello world " + i + "</p>" ; out.println(s); } %>

                    <hr>
                    <jsp:include page="./JSPBuiltIn.jsp" />
                    <h5> Lowercase example from example declaration in Expression</h5>
                    <%= getLowerCase("NATIONAL COLZz") %>

                        <hr>
                        <table border="1">
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Address</th>
                            </tr>
                            <c:forEach items="${studentList}" var="student">
                                <tr>
                                    <td>${student.id}</td>
                                    <td>${student.name}</td>
                                    <td>${student.address}</td>
                                </tr>
                            </c:forEach>
                        </table>
            </body>

        </html>