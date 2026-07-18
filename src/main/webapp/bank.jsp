<%--
  Created by IntelliJ IDEA.
  User: Welcome
  Date: 18/07/2026
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>J2EE-BANK</title>
    <link rel="icon" type="image/x-icon" href="https://img.icons8.com/external-dreamstale-lineal-dreamstale/32/external-bank-finance-dreamstale-lineal-dreamstale-4.png">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 flex items-center justify-center h-screen">

<div class="w-full max-w-md bg-white p-8 rounded-lg shadow-lg">
    <div class="flex justify-center mb-6">
        <!-- Using the favicon as a logo -->
        <img src="https://img.icons8.com/external-dreamstale-lineal-dreamstale/32/external-bank-finance-dreamstale-lineal-dreamstale-4.png" alt="Bank Logo" class="h-12 w-12">
    </div>
    <h2 class="text-2xl font-bold text-center text-gray-800 mb-8">Fund Transfer</h2>

    <!-- Fund Transfer Form -->
    <form action="test-bank" method="GET">
        <div class="mb-4">
            <label for="fromAccount" class="block text-gray-700 text-sm font-bold mb-2">From Account:</label>
            <input type="text" id="fromAccount" name="fromAccount" placeholder="Enter source account number"
                   class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>

        <div class="mb-4">
            <label for="toAccount" class="block text-gray-700 text-sm font-bold mb-2">To Account:</label>
            <input type="text" id="toAccount" name="toAccount" placeholder="Enter destination account number"
                   class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>

        <div class="mb-6">
            <label for="amount" class="block text-gray-700 text-sm font-bold mb-2">Amount:</label>
            <input type="text" id="amount" name="amount" placeholder="Enter amount to transfer"
                   class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
        </div>

        <div class="flex items-center justify-center">
            <button type="submit"
                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">
                Submit Transfer
            </button>
        </div>
    </form>
</div>

</body>
</html>
