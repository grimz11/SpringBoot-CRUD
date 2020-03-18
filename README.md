# SpringBoot-CRUD
-Install JavaSDK version 13.0.2(Latest at the moment).
-Install IDE either (Intellij, Spring Tools Suite, Netbeans or ...).
  -- If Intellij get the Community Edition.
-Mysql version 15.1.
-To run Mysql on port 3306(default) I used Xammp Panel.
-Git clone this repo and open this to Intellij. Intellij will initialize this for you(installing dependencies). 
 Just click yes if there's a prompt in the bottom right window.
-Then create database in my case I named it photo_app. (You can change it under root folder then navigate to src/main/resources/application.properties).
 -- You can change the user and password as well. But don't use root(maybe you'll run into an error or it won't start).
 -- After the creation of database (photo_app). Create a user (admin) and password (Hello101!). Then grant all privileges.
 -- To grant privileges. I used the command (GRANT ALL PRIVILEGES ON photo_app.* TO 'admin'@'localhost' IDENTIFIED BY 'Hello101!').
 -- Then (FLUSH PRIVILEGES)
 
 Okay you're all set up now. Next is to run the main method on Intellij. You might add a configuration if it won't start. 
 Then you can do request on postman or any other testing tool.
