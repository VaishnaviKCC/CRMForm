import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_Crm_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(3)
createTagBody(2, {->
createTagBody(3, {->
printHtmlPart(4)
invokeTag('layoutTitle','g',21,['default':("CRM form")],-1)
printHtmlPart(1)
})
invokeTag('captureTitle','sitemesh',22,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',22,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("viewport"),'content':("width=device-width, initial-scale=1")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',24,['src':("application.css")],-1)
printHtmlPart(5)
invokeTag('layoutHead','g',26,[:],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',27,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(8)
invokeTag('message','g',32,['code':("default.home.label")],-1)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',33,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',33,['class':("list"),'action':("index")],2)
printHtmlPart(10)
expressionOut.print(createLink(action: 'mylink'))
printHtmlPart(11)
expressionOut.print(creatLink(controller: 'Admin', action: 'index'))
printHtmlPart(12)
invokeTag('image','asset',52,['src':("grails-cupsonly-logo-white.svg")],-1)
printHtmlPart(13)
invokeTag('pageProperty','g',58,['name':("page.nav")],-1)
printHtmlPart(14)
invokeTag('layoutBody','g',65,[:],-1)
printHtmlPart(15)
invokeTag('message','g',70,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(16)
invokeTag('javascript','asset',73,['src':("application.js")],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1464178889000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
