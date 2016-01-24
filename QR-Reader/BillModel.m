//
//  BillModel.m
//  QR-Reader
//
//  Created by Sriram Vellangallor Subramanian on 1/23/16.
//  Copyright © 2016 Sriram Vellangallor Subramanian. All rights reserved.
//

#import "BillModel.h"

@implementation BillModel
- (instancetype)initProd:(NSString *)prodDescription price:(NSString *)strPrice{
    self = [super init];
    
    self.price = [strPrice floatValue];
    self.prodDescription = prodDescription;
    return self;
}
@end
