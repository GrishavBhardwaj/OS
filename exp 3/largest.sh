#! /bin/bash

echo "Enter 3 number followed by a space"
read -a numarr

if [[ ${numarr[0]} > ${numarr[1]} ]]
 then
    if [[ ${numarr[0]} > ${numarr[2]} ]]
    then
      echo ${numarr[0]}
    else echo ${numarr[2]}
    fi
 else
    if [[ ${numarr[1]} > ${numarr[2]} ]]
    then
      echo ${numarr[1]}
    else echo ${numarr[2]}
    fi
 fi
