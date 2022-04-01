# JetNoteApp
Jetnote app, allows you to make and save notes as you like.
Notes are saved using a room database, which was the learning objective behind this app.
Room database uses a Data Abstraction Object [DAO] to interact with the Database. 
Repository then abstracts this data from the DAO.
A view model is also implemented, which abstracts data from repository to share it with UI elements.

UI
Includes 2 text fields, one for title and another for description of note to be added. Followed by a save button.
Save button saves the added note in the scrollable list, which is placed below the button.
The note saved, can be popped out of the list by a simple tap.
