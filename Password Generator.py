#Password Generator

import random
import string

def generate_password(len):

    chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()?><~`{}[],."

    selected_char=random.sample(chars,len)
    
    pass_str = "".join(selected_char)

    return pass_str

if __name__ == "__main__":
    len=int(input('enter the length of password'))
        
    pass_str=generate_password(len)

    print("Random generated password:",pass_str)

    