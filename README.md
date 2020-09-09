# Java 按行读取解释器

## 0.这是什么

顾名思义，这个解释器未使用jython的情况下对python文件进行按行读取并模拟运行

起因是因为想让mc里运行python(像OC一样),但是有个问题

OC可以在玩家区块卸载或者退出游戏时保存lua程序运行进度和内存变量等

这个是我写不出的东西，于是突发奇想，按行读取不就好了

**我承认其局限性极大，但该程序只为尝试实现简单逻辑在mc里运行，不是为了与jython对立，所有东西都该用在正确的工作上才是最好的**

**本仓库不与mc直接相关，仅为理论测试**

## 1.局限性

为了提高按行读取的效率，有以下规则需要悉知

1. 程序必须以if __name__ == '__main__':作为运行起点，但是可以有def(未处理完成)
2. 变量只能声明为int类型，没有str类型
3. 运算时不能使用()
4. 不能外部导入

## 2. 为了打破局限性

再引入jython处理复杂逻辑，使用更广的库

若被解释的python代码中存在特殊规定样式的表达式块，则识别为导入外部方法，java程序则再使用jython处理

## 3.未来特性

- [ ] while的处理
- [ ] def的处理
- [ ] def的传参处理
- [ ] 比较式中允许使用字符串
- [ ] jython联动