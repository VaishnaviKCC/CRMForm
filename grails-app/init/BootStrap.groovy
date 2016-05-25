import org.example.*


class BootStrap {

    def init = { servletContext ->

    	SecUser admin = new SecUser(username:'admin', password:'secret', enabled:true).save()
    	SecRole royalty = new SecRole(authority: 'ROLE_ROYALTY').save()
    	SecUserSecRole.create(admin, royalty)
    	
    }
    def destroy = {
    }
}
