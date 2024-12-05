#Simple Calculator
#Using Arithmetic operations add,subtract,multiply,divide,module

def calculate(n1,n2,operation):
    if operation == 'add':
        print(n1+n2)
    elif operation == 'subtract':
        print(n1-n2)
    elif operation == 'multiply':
        print(n1*n2)
    elif operation == 'divide':
        print(n1/n2)
    elif operation == 'module':
        print(n1//n2)
        if n2!=0:
            print(n1/n2)
        else:
            print('invalid')
    else:
        print('invalid')


print('Simple Calculator')
print('Operations:add,subtract,multiply,divide,module(add,subtract,multiply,divide)')

n1=float(input('enter a number'))
n2=float(input('enter a number'))
operation=input('enter the operation')

result=calculate(n1,n2,operation)
print(f"The result of{operation}ing{n1}and{n2}:{result}")