package hello.springmvc.basic

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// RestController 는 문자를 반환하면 View 를 찾지 않고 문자 그대로 반환됨
@RestController
class LogTestController {
  private val logger = LoggerFactory.getLogger(javaClass)

  @RequestMapping("/log-test")
  fun logTest(): String {
    val name = "Spring"
    logger.trace("trace log={}", name)
    logger.debug("debug log={}", name)
    logger.info("info log={}", name)
    logger.warn("warn log={}", name)
    logger.error("error log={}", name)

    return "ok"
  }
}