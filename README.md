
# Personal Budget Tracker
A command-line Java application designed to help users track their personal finances. The program allows users to monitor their spending by tracking transactions, displays a total/remaining budget, and provides a breakdown of their budget usage. Users can add, modify, and view transactions to manage their finances effectively. Data is saved to a file for persistence across sections.


## Features
💰 𝗦𝗲𝘁 𝗠𝗼𝗻𝘁𝗵𝗹𝘆 𝗕𝘂𝗱𝗴𝗲𝘁: Define your total monthly spending limit

➕ 𝗔𝗱𝗱 𝗧𝗿𝗮𝗻𝘀𝗮𝗰𝘁𝗶𝗼𝗻𝘀: Record expenses with custom categories

📊 𝗕𝘂𝗱𝗴𝗲𝘁 𝗦𝘂𝗺𝗺𝗮𝗿𝘆: View budget utilization and remaining funds

🗂 𝗖𝗮𝘁𝗲𝗴𝗼𝗿𝘆 𝗕𝗿𝗲𝗮𝗸𝗱𝗼𝘄𝗻: View spending distribution across categories

🔄 𝗘𝗱𝗶𝘁/𝗗𝗲𝗹𝗲𝘁𝗲: Modify or remove existing transactions

♻️ 𝗥𝗲𝘀𝗲𝘁 𝗢𝗽𝘁𝗶𝗼𝗻𝘀: Clear budget, transactions, or both

💾 𝗗𝗮𝘁𝗮 𝗣𝗲𝗿𝘀𝗶𝘀𝘁𝗲𝗻𝗰𝗲: Automatic save/load functionality between sessions

𝗡𝗢𝗧𝗘: 𝗙𝗼𝗿 𝗱𝗮𝘁𝗮 𝘁𝗼 𝗽𝗿𝗼𝗽𝗲𝗿𝗹𝘆 𝗯𝗲 𝘀𝗮𝘃𝗲𝗱 𝗮𝗰𝗿𝗼𝘀𝘀 𝘀𝗲𝘀𝘀𝗶𝗼𝗻𝘀, 𝘆𝗼𝘂 𝗠𝗨𝗦𝗧 𝗰𝗹𝗼𝘀𝗲 𝘁𝗵𝗲 𝗽𝗿𝗼𝗴𝗿𝗮𝗺 𝗯𝘆 𝗶𝗻𝗽𝘂𝘁𝘁𝗶𝗻𝗴 𝗺𝗲𝗻𝘂 𝗼𝗽𝘁𝗶𝗼𝗻 "𝟴. 𝗘𝘅𝗶𝘁 𝗣𝗿𝗼𝗴𝗿𝗮𝗺 (𝗦𝗮𝘃𝗲 𝗗𝗮𝘁𝗮)". 𝗗𝗮𝘁𝗮 𝗺𝗮𝘆 𝗯𝗲 𝗹𝗼𝘀𝘁 𝗶𝗳 𝗽𝗿𝗼𝗴𝗿𝗮𝗺 𝗶𝘀 𝗰𝗹𝗼𝘀𝗲𝗱 𝗮𝗯𝗿𝘂𝗽𝘁𝗹𝘆.



## Demo

https://www.youtube.com/watch?v=DKN5ixQid1s


## Requirements
Java Development Kit (JDK) 8 or later
## Installation

𝗦𝘁𝗲𝗽 𝟭. 𝗖𝗼𝗺𝗽𝗶𝗹𝗲 𝘁𝗵𝗲 𝗽𝗿𝗼𝗴𝗿𝗮𝗺

Ensure you have all 3 files in the same directory:

• Main.java

• Budget.java

• Transaction.java

𝗦𝘁𝗲𝗽 𝟮. 𝗥𝘂𝗻 𝘁𝗵𝗶𝘀 𝗰𝗼𝗺𝗺𝗮𝗻𝗱 𝘁𝗼 𝗰𝗼𝗺𝗽𝗶𝗹𝗲:
```bash
javac Main.java Budget.java Transaction.java
```
𝗦𝘁𝗲𝗽 𝟯. 𝗥𝘂𝗻 𝘁𝗵𝗲 𝗮𝗽𝗽𝗹𝗶𝗰𝗮𝘁𝗶𝗼𝗻

Start the program with:
```bash
java Main
```
    
## Menu Options & How To Use
𝟭. 𝗦𝗲𝘁 𝗠𝗼𝗻𝘁𝗵𝗹𝘆 𝗕𝘂𝗱𝗴𝗲𝘁
- Enter a positive number to set your total monthly budget
𝟮. 𝗔𝗱𝗱 𝗧𝗿𝗮𝗻𝘀𝗮𝗰𝘁𝗶𝗼𝗻
- Enter a positive amount
- Enter a category for the transaction
𝗡𝗼𝘁𝗲: After adding at least one transaction, you'll be prompted to either select an existing category by number or enter a new one for future transactions.

𝟯. 𝗩𝗶𝗲𝘄 𝗕𝘂𝗱𝗴𝗲𝘁 𝗦𝘂𝗺𝗺𝗮𝗿𝘆
- Displays your total budget, remaining budget, and total spent so far
  
𝟰. 𝗩𝗶𝗲𝘄 𝗦𝗽𝗲𝗻𝗱𝗶𝗻𝗴 𝗯𝘆 𝗖𝗮𝘁𝗲𝗴𝗼𝗿𝘆
- Shows a breakdown of how much you've spent in total per category
  
𝟱. 𝗩𝗶𝗲𝘄 𝗔𝗹𝗹 𝗧𝗿𝗮𝗻𝘀𝗮𝗰𝘁𝗶𝗼𝗻𝘀
- Displays all transactions recorded.
  
𝟲. 𝗘𝗱𝗶𝘁/𝗗𝗲𝗹𝗲𝘁𝗲 𝗧𝗿𝗮𝗻𝘀𝗮𝗰𝘁𝗶𝗼𝗻
- Displays all transactions, simply enter the number of the transaction you wish to select
- Enter "1" to modify that transaction and set a new amount
- Enter "2" to delete the transaction
  
𝟳. 𝗥𝗲𝘀𝗲𝘁 𝗕𝘂𝗱𝗴𝗲𝘁, 𝗧𝗿𝗮𝗻𝘀𝗮𝗰𝘁𝗶𝗼𝗻𝘀, 𝗖𝗮𝘁𝗲𝗴𝗼𝗿𝗶𝗲𝘀
- Option to reset either only the budget, only the transactions (including categories), or both
- Includes an option to "leave as is" (no changes made)
  
𝟴. 𝗘𝘅𝗶𝘁
- Saves the data and stops the program.
- ​𝗬𝗼𝘂 𝗠𝗨𝗦𝗧 𝗲𝘅𝗶𝘁 𝘁𝗵𝗲 𝗽𝗿𝗼𝗴𝗿𝗮𝗺 𝘄𝗶𝘁𝗵 𝘁𝗵𝗶𝘀 𝗼𝗽𝘁𝗶𝗼𝗻 𝗲𝘃𝗲𝗿𝘆 𝘁𝗶𝗺𝗲 𝗶𝗻 𝗼𝗿𝗱𝗲𝗿 𝗳𝗼𝗿 𝘁𝗵𝗲 𝗱𝗮𝘁𝗮 𝘁𝗼 𝗯𝗲 𝘀𝗮𝘃𝗲𝗱 𝘀𝘂𝗰𝗰𝗲𝘀𝘀𝗳𝘂𝗹𝗹𝘆.
## Screenshots

![App Screenshot](https://i.postimg.cc/yNnWrd4G/Menu.png)



## Lessons Learned
I created this program because I enjoy learning about personal finance, and tracking my monthly budget is something that I have done for a while now manually using the Notes app on my iPhone.


This project:
- Gained an introduction to file I/O in Java, using BufferedReader and BufferedWriter to save and load data.
- Learned to use ArrayLists for storing objects like transactions and categories efficiently.
- Explored object-oriented programming principles, such as encapsulation, by creating separate classes for Budget and Transaction
- Improved my error handling skills by incorporating try-catch blocks to address potential exceptions.
- Developed better debugging skills through testing, including tracking the program flow with print statements to ensure everything worked as expected.
