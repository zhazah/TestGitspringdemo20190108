<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pagination</title>

    <!-- 分页组件基于jQuery -->
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.css" rel="stylesheet">

    <script src="/test/js/pagination.js"></script>
    <style>
        .page-container {
            margin: 20px 0;
        }

        .card {
            margin-bottom: 15px;
        }

        .page-option-btn {
            margin-right: 10px;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="row ">
        <div class="page-container"></div>
    </div>
    <div class="row page-list">
        <div class="col-md-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">card-text,card-text,card-text,card-text</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">card-text,card-text,card-text,card-text</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">card-text,card-text,card-text,card-text</p>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">card-text,card-text,card-text,card-text</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="page-container"></div>
    </div>

    <div class="row">
        <button class="btn btn-primary page-option-btn" id="btn_first_page">首页</button>
        <button class="btn btn-primary page-option-btn" id="btn_pre_page">上一页</button>
        <button class="btn btn-primary page-option-btn" id="btn_next_page">下一页</button>
        <button class="btn btn-primary page-option-btn" id="btn_last_page">末页</button>
        <button class="btn btn-primary page-option-btn" id="btn_jump_page">跳转到第5页</button>
    </div>
</div>

<script>
    const pageSize = 10
    const dataCount = 95
    const pager = new Pagination('.page-container', {
        pageSize: pageSize,
        autoLoad: true,
        unit: '条',
        toPage: function (index, _pageSize) {
            // 设置记录总数，用于生成分页HTML内容
        }
    })

    $("#btn_first_page").click((el) => {
        pager.handleToPage(0)
    setBtnDisabled()
    })
    $("#btn_pre_page").click(() => {
        pager.handleToPage(pager.pageIndex - 1)
    setBtnDisabled()
    })
    $("#btn_next_page").click(() => {
        pager.handleToPage(pager.pageIndex + 1)
    setBtnDisabled()
    })
    $("#btn_last_page").click(() => {
        pager.handleToPage(pager.pageCount - 1)
    setBtnDisabled()
    })
    $("#btn_jump_page").click(() => {
        pager.handleToPage(4)
    setBtnDisabled()
    })

    function setBtnDisabled() {
        $(".page-option-btn").removeClass("disabled")
        if (pager.pageIndex === 0) {
            $(".page-option-btn:nth(1)").addClass("disabled")
        }

        if (pager.pageIndex === pager.pageCount - 1) {
            $(".page-option-btn:nth(2)").addClass("disabled")
        }
    }
</script>
</body>

</html>