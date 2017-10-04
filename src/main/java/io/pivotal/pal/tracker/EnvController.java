package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String port;
    String memoryLimit;
    String CFInstanceIndex;
    String CFInstanceAddr;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String CFInstanceIndex,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String CFInstanceAddr) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.CFInstanceIndex = CFInstanceIndex;
        this.CFInstanceAddr = CFInstanceAddr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> envMap = new HashMap<>();

        envMap.put("PORT", this.port);
        envMap.put("MEMORY_LIMIT", this.memoryLimit);
        envMap.put("CF_INSTANCE_INDEX", this.CFInstanceIndex);
        envMap.put("CF_INSTANCE_ADDR", this.CFInstanceAddr);

        return envMap;
    }

}
