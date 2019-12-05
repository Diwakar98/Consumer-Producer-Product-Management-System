# Consumer-Producer-Product-Management-System
This is a simple model of consumer producer product management system. It works similar to Online Shopping Sites like Amazon, Flipkart, Myntra, etc.

Follow the steps run the project:
Run "Driver.java" file by executing the command: "javac Driver.java", followed by "java Driver" in terminal.

For input:
Give the input in the file named as "input.txt"
The first line of input is:
    catalog_size<SPACE>number_of_buyers<SPACE>number_of_sellers<SPACE>buyer_sleep_time<SPACE>seller_sleep_time
There after follows a number of line denoting products of various priorities.
The input of following lines is:
    priority_of_the_producer<SPACE>name_of_product<SPACE>price_of_the_product
    
For reference sample input and output file are also given.

ABOUT PROJECT:
This assignment is all about Multithreading. Utilising the concept of threading is not that easy.
I have used lock() function. When a thread is already processing the buy() or sell() function.
This does not allow other threads to entry until the current thread process the entire function.
In PriorityQueue class, we have to dequeue the item using priority of the sellers.
From input I am making objects of item and the adding it to Node with the priority of the sellers.
I am adding this Node to the arraylist.
Now I am parsing the queue and adding the item to the inventory queue.
After starting of the thread, I am adding the items to the catalog queue.
After the catalog is full, seller's thread start operating and starts to dequeue the items of the seller,
which has the minimum priority value(highest priority).
signal() function notify's the waiting thread that the process is completed so that the other threads starts operating.
unlock() function now unlocks the lock so that other thread can now enter.
I have used loops to make the object of the threads of the sellers and the buyers and to start their threads.
When I start thread of an object, its run function is called.
When I dequeue the items it is storing its object of minimum priority in a temporary variable, and
shifting the other items(to occupy the space) and decrementing the current size.
While inserting the items if the catalog is already full it return from the sell() function and
goes to the buyer thread to remove the items from the catalog.
While removing the items if the catalog is already empty its simply returns from the buy() function.
