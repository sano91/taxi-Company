# taxi-Company

You are to model a Taxi Company's annual (52 week) passenger amount. The Company has Cars and Drivers, it knows about all of them.
The Taxi Company can have 3 types of Cars available: Gasoline user, Electric and Self-Driving.
Each Car has a Unique id, a Cost (Gasoline - 350, Electronic - 400, Self-Driving - 740) and the Amount of passengers they will carry to their destination per week.
Gasoline Cars require a Driver and they have a Maintenance cost (20, +10% each week) as well. Electric cars require a Driver too.
A Driver has a Mobile-Number (5 digit number from 00001 or random), a Name, an Age, a Salary (salary is the same as cost for cars) and also how Experienced they are (Beginner, Advanced, Professional). The Drivers all know each others Mobile number (only the number, not  which driver it belongs to).
Based on this Experience (which we gave to each Driver randomly), they can handle more rides per week (Beginner - 15, Advanced - 25, Professional - 40 -> these are known by the car). The Drivers for the Cars are chosen randomly. 
You can assume every passenger pays 1 unit of money.
Self-Driving Cars are capable of carrying 70 passengers per week.

The Company can and will buy more Cars and Drivers if it has the money, but they can only buy Electronic or Self-Driving Cars (50-50 chance). For Electronic, they need to hire a Driver as well, which has a random Experience type from the 3 available.
Whenever a new Self-Driving Car is added to the Company's Car arsenal, all other Self-Driving Cars are out of order for maintenance for 1 week.
How many passengers did the Company gave a ride over a year?
