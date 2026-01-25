 Networking & Distributed Systems
This folder tracks my journey from basic socket programming to building fault-tolerant distributed systems.

 Learning Roadmap

  Level 1: Basic Client-Server Chat
     Concept: Establishing a TCP connection between a single client and a server.
     Goal: Client sends a message, and the server sends a response.

  Level 2: Multi-Client Server
     Concept: Using Multi-threading to handle multiple simultaneous connections.
     Goal: Multiple users connecting to a single chat server at the same time without the server crashing.

  Level 3: Distributed Systems Simulation (3 Nodes)
     Concept: Data replication and Leader Election.
     Goal: A simulation of 3 nodes where one node acts as a "Leader" to coordinate data storage across the other two nodes.
  

Objective: Build reliable communication between networked nodes.

Feature: Multi-threaded server and a 3-node distributed simulation with Leader Election.

Why: Shows mastery of Concurrency and the ability to build systems that handle multiple users simultaneously

NetworkingBasics: ![Image](https://github.com/user-attachments/assets/ae0a58fc-0e91-47b7-9f83-c1d1d7401a07) server talks and client listens 

ClientServerChat: ![Image](https://github.com/user-attachments/assets/8fe8ee5b-16a4-41fa-98db-df0ea5222020) a client ask balance and the server responds 

MultiClientServer ![Image](https://github.com/user-attachments/assets/465bba86-5bf9-42ff-843a-c14a6ecd429d) multiple clients asking for balance, reversal, deposit, withdrawal and the server handles all the requests


How to run using android 
1. open Jvdroid tool, click the folder icon, click open, choose storage for the folder, then choose new folder.
2. enter the name of the folder eg RetetiBankNetwork and save the folder 
3 click on the folder again, click new to create a Main.java by default file, 
4. go back to the folder icon, click save as and choose the folder you created RetetiBankNetwork to save your file that you can now name NetworkingBasics.java
5. click save, where your file will be saved in a folder.
6. create the files you require to use and save them in the your folder 
7. paste each code in it's respective file and click the yellowish triangle to run and it will give you the output.