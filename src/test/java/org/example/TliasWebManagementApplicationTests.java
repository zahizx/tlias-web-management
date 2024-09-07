package org.example;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TliasWebManagementApplicationTests {

   /* @Autowired
    private DeptService deptService;

    @Test
    public void testAopDelete() throws Exception {
        deptService.delete(10);
    }

    @Test
    public void testAopList() {
        System.out.println(deptService.list());
    }


    @Test
    public void testUuid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    *//**
     * 生成JWT
     *//*
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm")//签名算法
                .setClaims(claims)//自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期为1h
                .compact();
        System.out.println(jwt);
    }


    *//**
     * 解析JWT
     *//*
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnm")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcyMzY0OTg0NH0.GY9WHAyUlzEBlpKvbtBqf__bnT6WQRzpIUG-LESaGQM")
                .getBody();
        System.out.println(claims);

    }*/
}

