#n=int(input("Enter Number of iteration: "))
for i in range(1,51):
    if i%3==0:
        print(str(i)+"= Fizz")
    else:
        if i%5==0:
            print(str(i)+"= Buzz")
        else:
            if i%3==0 & i%5==0:
                print(str(i)+"= FizzBuzz")
            else:
                print(str(i))
