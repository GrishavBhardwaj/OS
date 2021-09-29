#! /bin/bash

echo "Enter a Number N"
read num

plus=$(( $num + 1 ))
dev=$(( $plus / 2 ))
sum=$(( $num * $dev ))
av=$(( $sum / $num ))

echo $av
