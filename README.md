This is an attempt to create an utility to convert OLE Automation Dates to java.util.Date's.


The OLE automation date format is a floating point value, 
counting days since midnight 30 December 1899. 
Hours and minutes are represented as fractional days.
An OLE Automation date is implemented as a floating-point number 
whose integral component is the number of days before or 
after midnight, 30 December 1899, and whose fractional component 
represents the time on that day divided by 24. 

For example, 
* 1.0 represents Midnight on 31 December 1899
* 2.25 represents 6 A.M. on 1 January 1900 
* -1.0 represents Midnight on 29 December 1899 
* -1.25 represents 6 A.M on 29 December 1899

The base OLE Automation Date is midnight, 30 December 1899. The 
minimum OLE Automation date is midnight, 1 January 0100. The maximum 
OLE Automation Date is the last moment of 31 December 9999.
