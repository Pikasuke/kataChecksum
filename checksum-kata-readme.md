
# Account Checksum

An account number is a nine digits string. It is said to be valid if its checksum is a multiple of 11. The checksum is calculated as follows:

    (c1*9 + c2*8 + c3*7 + c4*6 + c5*5 + c6*4 + c7*3 + c8 * 2 + c9)

Here are examples of valid account numbers:

    000000000 // 0 modulo 11 = 0
    130000000 // 1 * 9 + 3 * 8 = 33, 33 modulo 11 = 0
    000000051 // 5 * 2 + 1 * 1 = 11, 11 module 11 = 0
    123456789
    490867715
    999999990

## Console Application

Write a program that given an input file containing account numbers, outputs the same file with _invalid_ account numbers marked with a `*`.

Input example

    902542346
    505687420
    761694102
    034384618
    550081068
    188630350
    941325075
    362359628
    469431482
    992449121
    435736663
    267603738
    909215197
    176150170
    545527430
    063240745
    742228185
    197586201
    568361326
    531799301
    171943058
    187969213
    393347786
    425903206
    989552321

Output example

    902542346
    505687420*
    761694102
    034384618
    550081068*
    188630350*
    941325075
    362359628
    469431482
    992449121*
    435736663
    267603738
    909215197
    176150170*
    545527430
    063240745*
    742228185
    197586201
    568361326
    531799301
    171943058
    187969213
    393347786*
    425903206
    989552321*

## Web Application

Write a web app user page for account identification by users. The app will display a form 

    Name     : [                ]
    Password : [         ]
    Account Number : [            ]
    [Cancel] [Submit]

and display error messages in case the following controls are not satisfied:

- the Name field should not be empty, should not contain more than 30 chars. 
- the Password field should not be empty, and should not contain more than 30 chars.
- the Account Number field should not be empty, and contain a 9 digit account number that passes the checksum test.


