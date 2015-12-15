# HungryHippos 
#
# This is a program written from scratch, to play the game Hungry Hungry Hippos.
#
# When you run the program, a GUI Start Menu will appear. 
## If you press the Quit Button, then the program will terminate.
## If you press the Start Button, then the Start Menu window will close, and a new GUI Window will appear.

# This new GUI window will prompt you to choose the level of difficulty that you would like to play the game at.
## If you press Easy, then only simple Food (0's) will appear on the game board.
### "0" = 1 point.
## If you press Hard, then simple Food (0's) and special Food (+'s and -'s) will appear on the game board. 
### "0" = 1 point. "+" = 2 points. "-" = -1 point.
## If you press "nevermind", then the window will close and the program will terminate.
## Once the Easy or Hard Button is pressed, then the 2nd GUI window will close, and the rest of the game is played in console.

# When kicked back to console, Player 1 will be promted to choose either "a" or "l" in order to control their Hippo.
## They will be reminded which key they chose and where their Hippo is located on the board.
# Player 2 will then be prompted to choose either "a" or "l", based off of what Player 1 chose. 
## If Player 1 chose "a", then Player 2 will have to choose "l".
## They will also be reminded which key they chose and where their Hippo is located on the board.
## If either player enters a key that does not correspond with the prompt, then an error will be printed.
### The player will then be continuously told to type an acceptable key until they do so.

# After this is all done the game board will appear.
# When a player wants to move, they will have to type their key and press enter to move their Hippo onto the board.
## At this time the Food will randomize its position on the board. 
### Whichever Food pieces are within the Hippos snout will be collected and add to the corresponding Players score.
#### (The score board is located beneath the game board).
## The Food will randomly move to new spots each time a Player enters their key.
## If a player enters a key that was not their designated key, another error will be printed.
### They will again be promted to type an acceptable key until they do so.

# In both levels, the game will be finished when all the simple Food is collected.
## This means that the Hard level can be completed with collecting ANY special food (VERY unlikely, but possible).

# Once the game is over, the Player with the high score is presented as the winner.
## That player will then be able to enter their name to add it to a list of high scores.
## This list of high scores is ordered based on first winner to play the game, to last winner to play.
#
# That's it! Just run the program again if you thought it was fun!
