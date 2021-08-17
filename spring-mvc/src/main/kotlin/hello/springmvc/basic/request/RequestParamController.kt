package hello.springmvc.basic.request

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class RequestParamController {
  private val logger = LoggerFactory.getLogger(javaClass)

  @RequestMapping("/request-param-v1")
  fun requestParamV1(request: HttpServletRequest?, response: HttpServletResponse?) {
    val username = request?.getParameter("username")
    val age = request?.getParameter("age")?.toInt()
    logger.info("username={}, age={}", username, age)

    response?.writer?.write("OK")
  }
}