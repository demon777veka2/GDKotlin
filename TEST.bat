@echo off
setlocal enabledelayedexpansion

set  arrayline[0]= yourapp Hello bob. Hello steave.
set  arrayline[1]= yourapp Hello bob. hello steave.
set  arrayline[2]= yourapp Goodbay nikola2. goodbay nikola2
set  arrayline[3]= 
set  arrayline[4]=         
set  arrayline[5]=  echo "qwe qwe qwe" / yourapp 
set  arrayline[6]=  Echo "qwe qwe qwe" / yourapp
set  arrayline[7]=  echo "" / yourapp 
set  arrayline[8]=  yourapp 32 bob. Hello steaveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.


::read it using a FOR /L statement
for /l %%n in (0,1,8) do (
java -jar First.jar !arrayline[%%n]!
)
pause