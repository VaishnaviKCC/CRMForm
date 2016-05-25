package crm

class Account {
	String name
	String contact
	String address
	String email
    static constraints = {
    	name(blank : true)
    	contact(blank : true)
    	address(blank : true)
    	email(email : true)
    }
}
