#/bin/bash
echo "enter basic sal:"
read basal





da=$((basal * 40 / 100))
hra=$((basal * 20 / 100)) 

grosal=$((basal + da + hra))
echo "The gross salary : $grosal"










































