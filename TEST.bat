@echo off
setlocal enabledelayedexpansion

set  arrayline[0]= yourapp Hello bob. Hello steave.
set  arrayline[1]= yourapp Hello bob. hello steave.
set  arrayline[2]= yourapp Goodbay nikola2. goodbay nikola2
set  arrayline[3]= \s
set  arrayline[4]= \s\s\s\s\s\s\s        
set  arrayline[5]= echo "qwe qwe qwe" / yourapp 
set  arrayline[6]= Echo "qwe qwe qwe" / yourapp
set  arrayline[7]= echo "" / yourapp 
set  arrayline[8]= yourapp 32 bob. Hello steaveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.

set  array[0]= yourapp Hello bob. Hello steave.
set  array[1]= yourapp Hello bob. hello steave.
set  array[2]= yourapp Goodbay nikola2. goodbay nikola2
set  array[3]= \s
set  array[4]= \s
set  array[5]= echo "qwe qwe qwe" / yourapp 
set  array[6]= echo "qwe qwe qwe" / yourapp
set  array[7]= \s
set  array[8]= yourapp 32 bob. Hello steaveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee.

set /A koll = 0


::read it using a FOR /L statement
for /l %%n in (0,1,8) do (
echo ...................................................................
echo PeredaeLLI: !arrayline[%%n]!
echo Poly4aeLLI:
java -jar First.jar !arrayline[%%n]!

echo ...................................................................
echo PeredaeLLI: !arrayline[%%n]!
echo OjidaeLLI:
java -jar First.jar !array[%%n]!

if !arrayline[%%n]! == !array[%%n]! (set /a koll = !koll! + 1
 echo Test vipolnen korrektno) else (echo Test vipolnen nekorrektno)
)
echo Koli4estvo testov vipolnenih korrektno: !koll! iz 9
pause