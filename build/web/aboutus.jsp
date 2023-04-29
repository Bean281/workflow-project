<%-- 
    Document   : aboutus
    Created on : Apr 25, 2023, 5:08:53 PM
    Author     : CCLaptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            /* Three columns side by side */
            .column {
                float: left;
                width: 23%;
                margin-bottom: 16px;
                padding: 0 8px;
            }

            @media screen and (max-width: 650px) {
                .column {
                    width: 100%;
                    display: block;
                }
            }

            .card {
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                background-color: white;
                border-radius: 10px 10px 10px 10px;
            }

            .container {
                padding: 0 16px;
            }

            /* Clear floats */
            .container::after, .row::after {
                content: "";
                clear: both;
                display: table;
            }

            .title {
                color: grey;
            }

            .button {
                border: none;
                outline: 0;
                display: inline-block;
                padding: 8px;
                color: white;
                background-color: #000;
                text-align: center;
                cursor: pointer;
                width: 100%;
            }
            .card img {
                display: block;
                margin: 0 auto;
                width: 80%;
                height: 200px;
            }

            .header {
                text-align: center;
                font-family: monospace;
                font-size: large;
                color: white;
            }       
            body{
                background-color: #1f2937;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row">
            <div class="header">
                <h1>MEET THE TEAM</h1>
            </div>
            <div class="column">
                <div class="card ">
                    <img src="img/Khan.png" alt="Tuan">
                    <div class="container">
                        <h2 style="font-family: monospace;">Tieu An Tuan</h2>
                        <p class="title">Walking Bag, CEO of Tax Evasion</p>
                        <p style="font-family: monospace;">I feel like Shinjuku metro line .3.</p>
                        <p style="font-family: monospace;">KhanhKTFanclub@protonmail.com</p>
                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img src="./img/ab67616d0000b27382137f3ea7c9f2957d07e00b.jpg" alt="Quyen" >
                    <div class="container">
                        <h2 style="font-family: monospace;">Quyen</h2>
                        <p class="title">Professional Inter</p>
                        <p style="font-family: monospace;">I also love MU</p>
                        <p style="font-family: monospace;">@example.com</p>
                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img src="img/siu.png.jfif" alt="Dang">
                    <div class="container">
                        <h2 style="font-family: monospace;">Dang Lam</h2>
                        <p class="title">SIUUUUUUUU</p>
                        <p style="font-family: monospace;">I love MU</p>
                        <p style="font-family: monospace;">MUodayxahoi@example.com</p>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="card">
                    <img src="img/chovy" alt="Hung">
                    <div class="container">
                        <h2 style="font-family: monospace;">Hung</h2>
                        <p class="title">28</p>
                        <p style="font-family: monospace;">Edit me!</p>
                        <p style="font-family: monospace;">@example.com</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
