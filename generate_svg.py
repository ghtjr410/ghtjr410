import json

# 독서 기록 데이터 (JSON에서 불러올 수도 있음)
books = [
    {"title": "클린 코드", "start": 1, "end": 3, "color": "blue"},
    {"title": "리팩터링", "start": 2, "end": 5, "color": "green"},
    {"title": "이펙티브 자바", "start": 4, "end": 7, "color": "orange"}
]

# SVG 기본 설정
svg_header = '<svg width="800" height="200" xmlns="http://www.w3.org/2000/svg">\n'
svg_footer = "</svg>"

svg_body = ""

# X축 (월 표시)
for i in range(1, 13):
    x_pos = i * 60
    svg_body += f'<text x="{x_pos}" y="40" font-size="12" fill="black">{i}월</text>\n'

# Gantt Chart 스타일 막대 생성
y_position = 50
for book in books:
    x_start = book["start"] * 60
    width = (book["end"] - book["start"]) * 60
    svg_body += f'<rect x="{x_start}" y="{y_position}" width="{width}" height="20" fill="{book["color"]}" rx="5" ry="5"/>\n'
    svg_body += f'<text x="{x_start + width + 5}" y="{y_position + 15}" font-size="12" fill="black">{book["title"]}</text>\n'
    y_position += 40

# 최종 SVG 파일 생성
svg_content = svg_header + svg_body + svg_footer

# SVG 저장
with open("reading_timeline.svg", "w", encoding="utf-8") as f:
    f.write(svg_content)

print("✅ SVG 파일이 생성되었습니다! (reading_timeline.svg)")
