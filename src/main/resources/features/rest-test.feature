
#language: zh-CN
#"zh-CN": {
#    "but": "*|但是<",
#    "and": "*|而且<|并且<|同时<",
#    "then": "*|那么<",
#    "when": "*|当<",
#    "name": "Chinese simplified",
#    "native": "简体中文",
#    "feature": "功能",
#    "background": "背景",
#    "scenario": "场景|剧本",
#    "scenario_outline": "场景大纲|剧本大纲",
#    "examples": "例子",
#    "given": "*|假如<|假设<|假定<"
#  }

@bank
功能:假如我在银行取钱的时候，如果我登录成功并且输入的密码正确，那么会显示我的银行卡余额，假如余额为50万
  场景:银行取钱
    假如:我以"chhliu"登录
    并且:输入的密码为"123456"
    当:确认密码也为"123456"时
