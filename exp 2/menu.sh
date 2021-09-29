


#!/bin/bash

 

echo "SELECT Option to run command";
echo "1. List of Files"
echo "2. Process Status"
echo "3. Date"
echo "4. quit"

echo -n "Enter your menu choice [1-4]: "

 

while :
do
read choice

 

case $choice in
  1)  ls;;
  2)  ps;;
  3)  date;;    
  4)  echo "Quiting ..."
      exit;;

  *) echo "invalid option";;
  
esac
  echo -n "Enter your menu choice [1-4]: "
done 
