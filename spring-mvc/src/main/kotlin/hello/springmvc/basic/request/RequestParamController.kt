package hello.springmvc.basic.request

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
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

  @ResponseBody // 해당 Annotation 으로 View 를 찾지 않고 Http Body 에 문자열 담아서 반환
  @RequestMapping("/request-param-v2")
  fun requestParamV2(@RequestParam("username") memberName: String,
                     @RequestParam("age") memberAge: Int): String {
    logger.info("username={}, age={}", memberName, memberAge)
    return "ok"
  }

  @ResponseBody // 해당 Annotation 으로 View 를 찾지 않고 Http Body 에 문자열 담아서 반환
  @RequestMapping("/request-param-v3")
  fun requestParamV3(@RequestParam username: String,
                     @RequestParam age: Int): String {
    logger.info("username={}, age={}", username, age)
    return "ok"
  }

  @ResponseBody // 해당 Annotation 으로 View 를 찾지 않고 Http Body 에 문자열 담아서 반환
  @RequestMapping("/request-param-v4")
  fun requestParamV4(username: String, age: Int): String {
    logger.info("username={}, age={}", username, age)
    return "ok"
  }

  @ResponseBody // 해당 Annotation 으로 View 를 찾지 않고 Http Body 에 문자열 담아서 반환
  @RequestMapping("/request-param-required")
  fun requestParamRequired(@RequestParam(required = true) username: String,
                           @RequestParam(required = false) age: Int?): String {
    logger.info("username={}, age={}", username, age)
    return "ok"
  }

  @ResponseBody // 해당 Annotation 으로 View 를 찾지 않고 Http Body 에 문자열 담아서 반환
  @RequestMapping("/request-param-default")
  fun requestParamDefault(@RequestParam(defaultValue = "guest") username: String,
                           @RequestParam(defaultValue = "-1") age: Int): String {
    logger.info("username={}, age={}", username, age)
    return "ok"
  }

  @ResponseBody // 해당 Annotation 으로 View 를 찾지 않고 Http Body 에 문자열 담아서 반환
  @RequestMapping("/request-param-map")
  fun requestParamMap(@RequestParam paramMap: Map<String, Any?>): String {
    logger.info("username={}, age={}", paramMap["username"], paramMap["age"])
    return "ok"
  }
}