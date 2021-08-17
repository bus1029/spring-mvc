package hello.springmvc.basic.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import hello.springmvc.basic.HelloData
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Controller
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class RequestBodyJsonController {
  private val logger = LoggerFactory.getLogger(javaClass)
  private val objectMapper = ObjectMapper().registerKotlinModule()

  @PostMapping("/request-body-json-v1")
  fun requestBodyJsonV1(request: HttpServletRequest?, response: HttpServletResponse?) {
    val inputStream = request?.inputStream
    val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)

    logger.info("messageBody={}", messageBody)
    val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
    logger.info(helloData.toString())

    response?.writer?.write("ok")
  }

  @ResponseBody
  @PostMapping("/request-body-json-v2")
  fun requestBodyJsonV2(@RequestBody messageBody: String): String {
    logger.info("messageBody={}", messageBody)
    val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
    logger.info(helloData.toString())

    return "ok"
  }

  @ResponseBody
  @PostMapping("/request-body-json-v3")
  fun requestBodyJsonV3(@RequestBody helloData: HelloData): String {
    logger.info(helloData.toString())
    return "ok"
  }

  @ResponseBody
  @PostMapping("/request-body-json-v4")
  fun requestBodyJsonV4(httpEntity: HttpEntity<HelloData>): String {
    val helloData = httpEntity.body
    logger.info(helloData.toString())
    return "ok"
  }

  @ResponseBody
  @PostMapping("/request-body-json-v5")
  fun requestBodyJsonV5(@RequestBody helloData: HelloData): HelloData {
    logger.info(helloData.toString())
    return helloData
  }
}