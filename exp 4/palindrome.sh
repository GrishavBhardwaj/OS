echo "Enter a number: "
read num

s=0
rev=""
temp=$num
   
while [ $num -gt 0 ]
do
    # Remainder
    s=$(( $num % 10 ))  
      
    # next digit
    num=$(( $num / 10 )) 
      
    # store reverse
    rev=$( echo ${rev}${s} ) 
done
   
if [ $temp -eq $rev ];
then
    echo "Number is palindrome"
else
    echo "Number is NOT palindrome"
fi