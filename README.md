Monolithic application for Online Auction System using Rest APIs

3 users provided:
1. Administrator
2. Auctioneer
3. Bidder

Functionalities
1. Admin can add a user with the details to the database which can allow a user access to the application.
2. Database authentication is provided using Spring security and DaoAuthenticationProvider with encryption.
3. Admin can view all the open auctions/all auctions/all closed auctions and their status.
4. Bidder can see all open auctions and provide their bid entry
5. Auctioneer can create an auction entry with start date and time
6. Scheduler will run in the background and will update auction statuses to open or closed every day.
7. all this can be done with the help of restAPIs provided.
8. Uses PostGREs SQL as the database.
9. Foreign key/primary key relations in place for the Tables.

This is a monolithic application, for scalability can convert it to microservice architecturte and individually scale the heavy services.
