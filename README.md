# SSMB

## Bootstrap
### 视口介绍和配置
> 让网页中的1px=真实的1px，让显示内容不被视口缩小从而让人看不清  
> (视口以及视口的作用：在移动浏览器中，当页面宽度超出设备，浏览器内部虚拟的一个页面容器，将页面装到容器里，然后缩放到设备这么大，然以正常展示出页面上的所有内容后就可)

1. 目前大多数手机浏览器的视口（承载页面的容器）默认宽度都是980px；
2. `<meta name="viewport" content="width=device-width, initial-scale=1">`
    1. width:视口的宽度
    2. initial-scale：初始化缩放
    3. user-scalable:是否允许用户自行缩放（值：yes/no; 1/0）

### Bootstrap的栅格系统布局
> .container容器  
>（用于固定宽度并支持响应式布局的容器）  
> .container-fluid  
> (用于 100% 宽度，占据全部视口（viewport）的容器)  

* Bootstrap将浏览器屏幕宽度分为四个等级：
    1. `<768px` ---- 宽度100% （15+x+15）--- 1/12宽度(左右15px padding) --- .col-xs-
    2. `>=768px` ---- 宽度750px（15+720+15） --- 1/12宽度（槽30px） --- .col-sm-
    3. `>=992px` ---- 宽度970px（15+720+15） --- 1/12宽度（槽30px） --- .col-md-
    4. `>=1200px` ---- 宽度1170px（15+720+15） --- 1/12宽度（槽30px）--- .col-lg-

> 奇怪的是row的宽度是比container的宽度大30px的  
> （row中有margin： 0 -15px）

* 如果一“行（row）”中包含了的“列（column）”大于 12，多余的“列（column）”所在的元素将被作为一个整体另起一行排列
    1. 9 + 4 > 12 则4另起一行

> 媒体查询  
> 进行响应式设计的核心要素  
> （主要用到 min-width（下限），max-width（上限），and语法）  
* 语法：
    1. @media(min-width){ 以下样式生效 }
    2. 注意点  
        （按CSS定义的顺序渲染，所有要主要@media的顺序）
    
> 栅格系统的基本使用  
1. 列组合
    * col-xs-*
2. 列偏移
    * col-xs-offset-*  （这个其实调整的是元素左侧的margin，由于列元素是浮动的，所以影响到整个行）
    * col-xs-push-*  (这两个产生的影响会使列重合，使用这个可以改变列顺序)
    * col-xs-pull-*
3. 列嵌套
    
4. 列排序
    * col-xs-push-*
    * col-xs-pull-*
    
5. 浮动
    * `<div class="clearfix visible-sm"></div>` 也就是当sm屏幕的时候清除前后浮动

> 文字排版  
1. body ： 背景白，margin 0
2. 超链接：字体蓝色，hover有下划线
3. 标题 h1 36px ~ h6 12px  
    （还提供.h1 ~ .h2类供inline元素赋予标题的样式）  
    （配合small标签和.small类来标记副标题）
4. 页面主体  
    * 全局font-size = 14px
    * line-height = 1.428
    * p元素设置了1/2的line-height（10px）的底部margin
    * 对齐 .text-*
    * 列表 ul ol .list-unstyled .list-inline
    * 描述 .dl-horizontal 水平排列描述

> 表格  
1. .table（默认宽度为100%）  
    (赋予基本的表格样式：th加粗，加少量padding等)
2. .table-striped  
    (给tbody之内的行加斑马条纹，其实使用的使:nth-child来实现 .table-striped > tbody > tr:nth-of-type(odd))
3. .table-bordered  
    (为表格和单元格之间加边款)
4. .table-hover
5. .table-condensed  
    (使表格更加紧凑---单元格上紧凑，减小padding)
6. 为单元格或行设置颜色（tr th td元素上使用）  
    (.active .success .info .warning .danger)
7. 响应式表格（其实本身就是响应式表格）  
    （将.table 放入到 .table-responsive元素中）

> 表单  
1. .form-group (加上margin-bottom:15px)
2. .form-control (设置宽度100%，高度20px，padding，focus，placeholder样式等)  
    （为input，textarea，select等元素赋予样式）
3. 内联表单(.form-inline)
4. 横向表单布局（.form-horizontal类）  
    * 这回改变.form-group类的行为，使其表现为栅格系统中的行row，这样无序添加.row了
    * 联合使用栅格类，可以将label标签和控件组水平布局
    * label上的.control-label类使得label标签和控件垂直居中
5. 多选框和单选框  
    * .checkbox类 和 .checkbox-inline类
    * .radio类 和 .radio-inline类
    ```
    <div class="checkbox">
      <label>
        <input type="checkbox" value="">
        Option one is this and that&mdash;be sure to include why it's great
      </label>
    </div>
   ```
6. 自动获取焦点 ---- autofocus 属性
7. 添加额外标签  
    ```
    <div class="col-md-5 has-feedback ">
        <input autofocus class="form-control" placeholder="username" type="text" name="username" />
        <span class="glyphicon glyphicon-ok form-control-feedback"></span>
    </div>
   ```
8. 改变控件大小  
    * xxx-sm  xxx-lg

> 按钮  
1. a、button、input元素添加按钮类 .btn .btn-defalut 即可使用bootstrap按钮样式
2. .btn-block (使按钮变成块级元素，width=100%)
3. .btn-lg .btn-sm 等修改大小

> 图片  
1. 响应式图片 .img-responsive类  
    实质上（max-width=100% height=auto display=block）  
    水平居中需要使用 （.center-block 不要使用 .text-center)
2. 图片形状  
    * .img-circle  (设置 border-radius=50%)
    * .img-rounded  (设置 border-radius)
    * .img-thumbnail

> 辅助样式  
1. 情景文本颜色
    * .text-muted
    * .text-success
2. 情景背景色
    * .bg-info
    * .bg-warning
3. 关闭按钮 
    ```
    <button type="button" class="close" aria-label="Close"><span aria-hidden="true">&times;</span></button>
   ```
4. 三角符号  
    ```
    <span class="caret"></span>
   ```
5. 快速浮动     
    ```
    <div class="pull-left">...</div>
    <div class="pull-right">...</div>
   ```
6. 显示或隐藏内容(!important)  
    * .show
    * .hidden
    * .sr-only除了屏幕阅读器外，隐蔽元素

> 响应式工具  
1. 可用的类
    * .visible-xs-*只在超小屏可见 （*指 block、 inline、 inline-block）
    * .hidden-xs 只在超小屏上隐藏

> 下拉菜单  
1. .dropdown  
    ```
    <div class="dropdown">
        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
            下拉菜单
            <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="#">下拉菜单</a></li>
            <li><a href="#">下拉菜单</a></li>
            <li><a href="#">下拉菜单</a></li>
            <li><a href="#">下拉菜单</a></li>
        </ul>
    </div>
   ```
2. 向上弹出（将.dropdown 换成 .dropup)
3. 为下拉菜单添加标题和分割线  
    * `<li class="dropdown-header>标题</li>`
    * `<li role="separator" class="divider"></li>`

> 按钮组  
1. .btn-group (将各按钮之间的间隙减为0，将div变成inline-block元素)
2. .btn-group-vertical (垂直)
3. 可以整合下拉菜单（.btn-group 和 .dropdown 效果一样）   
```
    <div class="btn-group">
        <button class="btn btn-default">按钮1</button>
        <button class="btn btn-default">按钮2</button>
        <button class="btn btn-default">按钮3</button>
        <button class="btn btn-default">按钮4</button>
        <div class="btn-group">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                下拉菜单
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
                <li><a href="#">下拉菜单</a></li>
                <li><a href="#">下拉菜单</a></li>
                <li><a href="#">下拉菜单</a></li>
                <li><a href="#">下拉菜单</a></li>
            </ul>
        </div>
    </div>
```

> 输入框组  
1. 基于文本的输入框添加前缀和后缀的文本或按钮  
```
    <div class="input-group">
        <span class="input-group-addon">@</span>
        <input type="text" class="form-control"/>
        <span class="input-group-btn">
            <button class="btn btn-default" type="button">GO!</button>
        </span>
    </div>
```

2. 


> 导航  
1. 导航元素(必须有a标签)
    * 标签式导航
        ```
      <ul class="nav nav-tabs">
          <li class="active"><a href="#">导航1</a></li>
          <li><a href="#">导航2</a></li>
          <li><a href="#">导航3</a></li>
      </ul>
      ```
    * 胶囊式导航
        * .nav-pills
    * 垂直排列 .nav-stacked
    * 水平排列时 .nav-justified 铺满父容器宽度
        * nav nav-pills nav-stacked nav-justified 一起使用时  
            （小屏幕时垂直，大屏幕时水平铺满）
    
2. 结合下拉菜单  
    * 把a标签转换成下拉按钮