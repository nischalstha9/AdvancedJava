<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Form Data</title>
    </head>

    <body>
        <h1>Hello ${param.username}!</h1>
        <h1>
            Hello <%= request.getParameter("username") %> again!!
        </h1>
        <h1>
            Your Location: <%= request.getParameter("country") %>
        </h1>
        <br>

        <hr>
        Your Drinks:
        <%
        String[] drinks = request.getParameterValues("drinks");
        for(String d: drinks){
            out.println(d);
            out.println(",");
        }
        %>

        <hr>


        The request method is <%= request.getMethod() %>
        <br>
        <%
        Cookie[] cs = request.getCookies();
        out.println(cs.length);
        out.println("<br/>");
        for (Cookie c : cs) {
            out.println(c.getName()+"-->");
            out.println(c.getValue());
            out.println("<br/>");
        }
        Cookie nc = new Cookie("HeroName", request.getParameter("username"));
        nc.setMaxAge(60*60);
        response.addCookie(nc);
        %>

    </body>

</html>