package crm
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
class F_pageController {
	@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def index() {
    	render "Welcome to crm form" }
}
