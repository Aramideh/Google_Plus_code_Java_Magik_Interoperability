# Google Plus Code capability with Magik–Java™ interoperability

## Google Plus Code capability with Magik–Java™ interoperability


### Introduction


At Smallworld 5.1, a supported mechanism is provided for a Magik session to call code written in Java™. This provides 
an efficient way of exposing Java to Magik, allowing access to existing Java code and third-party libraries written in Java. (GE Documentation )

In one of my previous repositories I wrote a code to add google's plus code ( google's open location code ) capability to smallwolrd, 
that repository was purely written in Magik language. In this repository I'm exploring the Magik–Java™ interoperability which was introduced in the Smallwolrd core 5.1 .

In this repository all the code is written in Java and then it's exposed to Smallworld via Magik–Java™ interoperability.



### Getting Started

for convinence please copy the files in the specified directories.

* copy swj_open_location_code in Magik_Module folder to the %SMALLWORLD_GIS%\interop.demo\interop_demo_product\modules\
* copy SW_Google_Open_Location_Magik_Java_Interop.jar in jar folder to %SMALLWORLD_GIS%\interop.demo\interop_demo_product\libs\
* smallworld_product.add_product(:interop_demo_product)
* compile the modules
* If the comilation is successfull you would see sw_interop_demo.swj_open_location_code.1.jar at the %SMALLWORLD_GIS%\interop.demo\interop_demo_product\libs\

#### Classes:
	Two classes are defined open_location_code and open_location_code_area
	* All static methods of the original google's java class is exposed, even though there are fewer methods because of the Optional parameter in Magik language
	
	* Java documentation is available inside the doc folder, the methods are applicable for magik.



####	Simple Example:
```

_block 

	## returns an open_location_code object with latitude 35.7459617 and longitude 51.3735429
	 aOpenLocObj << open_location_code.new( 35.7459617,51.3735429 ) 
	
	##  returns the encoded plus code : in this case it will return a string with value of "8H7HP9WF+9C" 
	 aPlusCode << aOpenLocObj.encode()
	 
	 

	
	## The below line will have the same result of the above
	write("You are initiating a open_location_code with latitude 35.7459617 and longitude 51.3735429 ")
	 aPlusCode << open_location_code.encode(35.7459617,51.3735429 ) 
	 write("open_location_code object is created, parameters for this object are:")
	 write( "latitude : ",aOpenLocObj.get_latitude() ,%tab , "Longitude : " ,aOpenLocObj.get_longitude() ,%tab , "Code Length : " , aOpenLocObj.get_code_length() ,%newline)
	 write( %newline)
	 write("**************Static Methods***************" ,%newline)
	 write(%newline)
	 write( %tab,"Code is a full Open Location Code. : ", open_location_code.is_full?(aPlusCode)  ,%newline)
	 write( %tab,"Code is a full Open Location Code and valid : ",  open_location_code.is_full_code?(aPlusCode) ,%newline )
	 write( %tab,"code contains less than 8 valid digits : ", open_location_code.is_padded?(aPlusCode)  ,%newline)
	 write( %tab,"Code is a short Open Location Code : " ,open_location_code.is_short?(aPlusCode)  ,%newline)
	 write( %tab,"code is a valid short Open Location Code : " , open_location_code.is_short_code?(aPlusCode)  ,%newline)
	 write( %tab,"whether the provided string is a valid Open Location code. : " , open_location_code.is_valid_code?(aPlusCode)  ,%newline)
	 write(%newline)	
	 write("**************End of Static Methods***************" ,%newline)
	 write(%newline)	
 
	 write("Returns whether the bounding box specified by the Open Location Code contains provided point"  ,%newline)
	 write(%tab,"Contains the Latitude 35.7459617 and Longitude 51.3735429 ?",%tab , aOpenLocObj.contains?(35.7459617,51.3735429)  ,%newline)
	 write(%tab,"Contains the Latitude 35 and Longitude 51 ?",%tab , aOpenLocObj.contains?(35,51)  ,%newline)
	 write(%newline)	


	 write("Changing the current Open_Location_object latitude and longitude and length to latitude 35 , longitude 51 and code length 12" ,%newline)
	 aOpenLocObj.set_latitude( 35 )
	 aOpenLocObj.set_longitude( 51 )
	 aOpenLocObj.set_code_length( 12 )
	 write( %tab , "latitude : ",aOpenLocObj.get_latitude() ,%tab , "Longitude : " ,aOpenLocObj.get_longitude() ,%tab , "Code Length : " , aOpenLocObj.get_code_length()  ,%newline)


	 
	 
		
	write("Decoding the plus code will result in open_location_code_area object, using the method decode() ")
	 
	 aCodeAreaObj << aOpenLocObj.decode()
	 write("open_location_code_area is created")
	 ## The below line will have the same result of the above
	 aCodeAreaObj << open_location_code.decode("8H7HP9WF+9C" )
	 
	 
	 
	 ## Defined methods are :
	 ## get_south_latitude()
	 ## get_west_longitude()
	 ## get_north_latitude()
	 ## get_east_longitude()
	 ## get_length()
	 ## get_center_latitude()
	 ## get_center_longitude()
	 ## get_latitude_height()
	 ## get_longitude_width()
	 write(%newline)
	 write(" Querying the open_location_code_area object ")
	 write(%tab,"south_latitude",%tab,"west_longitude",%tab,"north_latitude",%tab,"east_longitude" ,%newline)
	 write(%tab,aCodeAreaObj.get_south_latitude() ,%tab , aCodeAreaObj.get_west_longitude() ,%tab , aCodeAreaObj.get_north_latitude() ,%tab , aCodeAreaObj.get_east_longitude()  ,%newline)
	 write(%newline)
	 write("Length is  : ", aCodeAreaObj.get_length()  ,%newline)
	 write(%newline)
	 write("center_latitude : ",	aCodeAreaObj.get_center_latitude()	,%newline,  "center_longitude : "  , aCodeAreaObj.get_center_longitude()  ,%newline)
	 write(%newline)
	 write( "latitude_height : " ,aCodeAreaObj.get_latitude_height() ,%newline , "longitude_width : " ,aCodeAreaObj.get_longitude_width()  ,%newline)
 	
_endblock 
$


```

* Above block code's result woul be :
```

You are initiating a open_location_code with latitude 35.7459617 and longitude 51.3735429 open_location_code object is created, parameters for this object are:latitude : 35.75	Longitude : 51.37	Code Length : 10

**************Static Methods***************

	Code is a full Open Location Code. : True
	Code is a full Open Location Code and valid : True
	code contains less than 8 valid digits : False
	Code is a short Open Location Code : False
	code is a valid short Open Location Code : False
	whether the provided string is a valid Open Location code. : True

**************End of Static Methods***************

Returns whether the bounding box specified by the Open Location Code contains provided point
	Contains the Latitude 35.7459617 and Longitude 51.3735429 ?	True
	Contains the Latitude 35 and Longitude 51 ?	False

Changing the current Open_Location_object latitude and longitude and length to latitude 35 , longitude 51 and code length 12
	latitude : 35.00	Longitude : 51.00	Code Length : 12
Decoding the plus code will result in open_location_code_area object, using the method decode() open_location_code_area is created
 Querying the open_location_code_area object 	south_latitude	west_longitude	north_latitude	east_longitude
	35.75	51.37	35.75	51.37

Length is  : 10

center_latitude : 35.75
center_longitude : 51.37

latitude_height : 0.0001250
longitude_width : 0.0001250

	
	
```


### Author Notes

 * This modules is tested on Smallworld 5.1.9 (Long support )
	



### Authors
* [**Sadeq Aramideh**](https://github.com/Aramideh)



 