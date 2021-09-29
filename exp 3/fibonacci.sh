#! /bin/bash

echo -e "Enter a Number: \c"
read num

t1=0
t2=1
tt=$(($t1+$t2))

echo $t1
echo $t2
for var in $(seq 3 $num);
  do  
        echo $tt
        t1=$t2
        t2=$tt
        tt=$(($t1+$t2))
  done
