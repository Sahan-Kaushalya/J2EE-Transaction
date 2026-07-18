<%--
  Created by IntelliJ IDEA.
  User: Welcome
  Date: 11/07/2026
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>J2EE-Transaction</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

<div class="container mx-auto mt-10">
    <div class="bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-4xl font-bold text-center text-gray-800 mb-6">Welcome to J2EE-Transaction</h1>
        <p class="text-center text-gray-600 mb-8">This is a simple demonstration of a J2EE application with JTA.</p>

        <div class="flex justify-center">
            <a href="test" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                Run Test Servlet
            </a>
        </div>
    </div>
</div>

<div class="container mx-auto mt-10">
    <div class="bg-white p-8 rounded-lg shadow-md">
        <h1 class="text-4xl font-bold text-center text-gray-800 mb-6">New User Registration</h1>
        <p class="text-center text-gray-600 mb-8">This is a simple demonstration of a J2EE application with JTA Connections.</p>

        <form action="test-register" method="get" class="flex flex-col items-center gap-4">
            <label for="username" class="text-gray-700 font-medium">Username</label>
            <input
                    id="username"
                    type="text"
                    name="username"
                    placeholder="Enter username"
                    required
                    class="w-full max-w-md border border-gray-300 rounded px-4 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"
            />

            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                Register New User
            </button>
        </form>
    </div>
</div>

</body>
</html>