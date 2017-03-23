#!/usr/bin/python
from sys import argv
import zbar
import Image
import time

if len(argv) < 3:
    print 'error ,please input : ./scancode - help'
    exit(1)
if argv[1] == '-':
    print '1. camera : ./scancode -v /dev/vedio(0-9)'
    print '2. photo  : ./scancode -p ****.png'
if argv[1] == '-p':
    # create a reader
    scanner = zbar.ImageScanner()
    # configure the reader
    scanner.parse_config('enable')
    # obtain image data
    pil = Image.open(argv[2]).convert('L')
    width, height = pil.size
    raw = pil.tostring()
    # wrap image data
    image = zbar.Image(width, height, 'Y800', raw)
    begin = time.clock()
    # scan the image for barcodes
    scanner.scan(image)
    end = time.clock()
    print 'run time :',(end - begin)*1000 ,'ms'
    # extract results
    for symbol in image:
    # do something useful with results
        print 'decoded', symbol.type, 'symbol', '"%s"' % symbol.data
    # clean up
    del(image)
if argv[1] == '-v':
    # create a Processor
    proc = zbar.Processor()
    # configure the Processor
    proc.parse_config('enable')
    # initialize the Processor
    device = argv[2]
    proc.init(device)
    # enable the preview window
    proc.visible = True
    # read at least one barcode (or until window closed)
    proc.process_one()
    # hide the preview window
    proc.visible = False
    # extract results
    for symbol in proc.results:
        # do something useful with results
        print 'decoded', symbol.type, 'symbol', '"%s"' % symbol.data
