BLOGGING SITE PROJECT  

Basic blog project with MVC design pattern.



Prerequisites

You can open this project with Eclipse or any other IDE which is support JAVA projects.
Also you need to create proper databases in PostgreSQL. You can find the needed query to create databases 
in path /BloggingSiteProject/src/main/java/SQL/Query.sql in project.
Please check the  - DatabaseInformation()- method informations if they are ok for yours database or not.
Path:   /BloggingSiteProject/src/main/java/blogProject/dataBaseCon/DatabaseInformation.java 



Versioning

This project has been created with Java-16.




Getting Started

Please run -main- class to see how this project work.
You wiil see a menu shown below when you run the main class,



    ----------------------------------------
		BLOG PROJESI GIRIS       
		----------------------------------------
		00 . Yeni Admin Girisi              
		01 . Mevcut Admin Girisi            
		02 . Yeni Kullanici Girisi          
		03 . Mevcut Kullanici Girisi        
		04 . Uygulamadan Cikis              
		----------------------------------------
    Lutfen yapmak istediginiz islemi seciniz:
    
This is where you first choose your action. First you need to be pretend as an admin please enter 0 and follow instroductions. Admin informations has been work on local txt file first, admin name surname , password all those informations will be added both local txt file which is already created inside the project folders and also postgres database. After first login when you try to login as an admin, programe will be check if your input are correct or not from local txt file.If you try to login as a user, programe will be check your user mail and pasword from database.There is no readable password seeing on database . The passwords will be encode by base64 before sending the database and read it with decode by base64.

After this part has been done you need to create some users acount which will work on just postgres database.

After creating admin and users account you can start to use other options which will allow you to chat if you are login as a user or see informations or do chat if you login as an admin.

More actions and GUI will be added on project very soon.

Have Fun!!!



Authors
Gulten Ulukal
