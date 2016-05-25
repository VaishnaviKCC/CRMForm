package crm
import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;

@Transactional(readOnly = true)
class AccountController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def index() {
    }
    @Secured(['ROLE_ROYALTY'])
    def mylink(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Account.list(params), model:[accountCount: Account.count()]
    }
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def show(Account account) {
        respond account
    }
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def create() {
        respond new Account(params)
    }
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    @Transactional
    def save(Account account) {
        if (account == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (account.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond account.errors, view:'create'
            return
        }

        account.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'account.label', default: 'Account'), account.id])
                redirect account
            }
            '*' { respond account, [status: CREATED] }
        }
    }
    
    def edit(Account account) {
        respond account
    }
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    @Transactional
    def update(Account account) {
        if (account == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (account.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond account.errors, view:'edit'
            return
        }

        account.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'account.label', default: 'Account'), account.id])
                redirect account
            }
            '*'{ respond account, [status: OK] }
        }
    }

    @Transactional
    def delete(Account account) {

        if (account == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        account.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'account.label', default: 'Account'), account.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'account.label', default: 'Account'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
